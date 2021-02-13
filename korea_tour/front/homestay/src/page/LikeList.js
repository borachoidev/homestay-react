import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { URL } from '_utils/api';
import store from '_store/Store';

import ListRow from "components/ListRow";
import Pagination from 'components/Pagination';
import 'components/LikeList.css';
const LikeList  =()=> {
    

    const [likeList,setLikeList] = useState(null);
    const [loading,setLoading] = useState(false);
    const [currentPage, setCurrentPage] = useState(1);
    const [postsPerPage, setPostsPerPage] = useState(10);

      let userNum=store.getState().userReducer.num;

   useEffect(() =>{
       // async를 사용하는 함수 따로 선언
       const fatchData = async ()=> {
           setLoading(true);
           try {
               const response = await axios.get(
                   `${URL}/mypage/marks/${userNum}`
               );
               setLikeList(response.data);

           } catch (e) {
               console.log(e);
           }
           setLoading(false);
       };
       fatchData();
   }, []); 

   if (loading) {
       return <p>대기중....</p>;
   }
   //articles 값이 설정되지 않았을때
   if (!likeList) {
    return null;
   }

   const indexOfLast = currentPage * postsPerPage;
    const indexOfFirst = indexOfLast - postsPerPage;
    function currentPosts(tmp) {
      let currentPosts = 0;
      currentPosts = tmp.slice(indexOfFirst, indexOfLast);
      return currentPosts;
    }
     let likeListCount = likeList.marks;
     let totalCount = likeList.totalCount; 
   // articles 값이 유효할때   
        return (
            <div style={{marginTop:30}}>
           <b className="like_list_title">내가 찜한 홈스테이</b>
           <hr className="like_list_hr" style={{marginTop:20}}/>
           <div className="like-List">
               {currentPosts(likeListCount).map((likeListCount,index)=>
              (<ListRow
                likeNum ={likeListCount.homeStayMarkNum}
                homeNum = {likeListCount.homeStayNum}
                title = {likeListCount.title}
                hostNum ={likeListCount.hostNum}
                hostName = {likeListCount.hostName}
                addr={likeListCount.addr1}
                photo={likeListCount.homeStayPhoto}
                star={likeListCount.avgOfStars}
                key={index}
              />) 
               )} 
           </div>
                <Pagination postsPerPage={postsPerPage} totalPosts={totalCount} paginate={setCurrentPage}  align="center"></Pagination>
           </div>
        );
    
}
export default LikeList;