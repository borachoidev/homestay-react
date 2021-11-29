import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { URL } from '_utils/api';
import store from '_store/Store';

import MyRow from "components/MyReviewRow";
import "components/MyReviewList.css"
import Pagination from 'components/Pagination';


const MyReviewList =()=>{
    const [reviewList,setReviewList] = useState(null);
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
                `${URL}/mypage/reservations-for-review/${userNum}`
            );
            setReviewList(response.data);
            console.log(response.data);
        } catch (e) {
            console.log(e);
        }
        setLoading(false);
    };
    fatchData();
    }, []); 

    if (loading) {
        return <p>값을 불러오는 중입니다..</p>;
    }
     //articles 값이 설정되지 않았을때
    if (!reviewList) {
     return null;
    }

    const indexOfLast = currentPage * postsPerPage;
    const indexOfFirst = indexOfLast - postsPerPage;
    function currentPosts(tmp) {
      let currentPosts = 0;
      currentPosts = tmp.slice(indexOfFirst, indexOfLast);
      return currentPosts;
    }
     let reviewCount = reviewList.reservations;
     let totalCount =reviewList.totalCount;
     // articles 값이 유효할때
        return (
            <div style={{marginTop:30}}>
                <b className="review_list">리뷰쓰기</b>
                <hr className="review_list_hr" style={{marginTop:20}}/>
              {currentPosts(reviewCount).map((reviewCount,index)=>
                (<MyRow
                  ReservationNum = {reviewCount.homeStayReservationNum}
                  checkIn ={reviewCount.checkInDay}
                  checkOut ={reviewCount.checkOutDay}
                  homeStayNum = {reviewCount.homeStayNum}
                  title = {reviewCount.homeStayTitle}
                  housePhoto ={reviewCount.homeStayPhoto}
                  review ={reviewCount.reviewWrite}
                  key={index}
                />) 
                 )}

                 {/* 페이징 처리 */}
                {totalCount>1
                ?
                <Pagination postsPerPage={postsPerPage} totalPosts={totalCount} paginate={setCurrentPage}  align="center"></Pagination>
                :<Pagination postsPerPage={postsPerPage} totalPosts={9} paginate={1}  align="center"></Pagination>}
            </div>
        )
}

export default MyReviewList;