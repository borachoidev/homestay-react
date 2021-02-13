import React, { useEffect, useState } from 'react';
import axios from 'axios';
import store from '_store/Store';
import { URL } from '_utils/api';

import MyWriteReviewRow from 'components/MyWriteReviewRow';
import Pagination from 'components/Pagination';
import 'components/MyWriteReview.css'
const  MyWriteReview = () => {
    
    const [myReview,setMyReview] = useState(null);
    const [loading,setLoading] = useState(false);
    const [currentPage, setCurrentPage] = useState(1);
    const [postsPerPage, setPostsPerPage] = useState(5);

    let loginNum=store.getState().userReducer.num;


    useEffect(() =>{
    // async를 사용하는 함수 따로 선언
    const fatchData = async ()=> {
        setLoading(true);
        try {
            const response = await axios.get(
                `${URL}/mypage/reviews/${loginNum}`
            );
            setMyReview(response.data);
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
   if (!myReview) {
    return null;
   }

   const indexOfLast = currentPage * postsPerPage;
   const indexOfFirst = indexOfLast - postsPerPage;
   function currentPosts(tmp) {
     let currentPosts = 0;
     currentPosts = tmp.slice(indexOfFirst, indexOfLast);
     return currentPosts;
     
   }

   let reviewsCount = myReview.reviews;
   let totalCount = myReview.totalCount; 
   console.log(totalCount);
   // articles 값이 유효할때 
    return (
          <div style={{marginTop:30}}>
              <h1 className="my_write_review_main">내가 쓴 리뷰</h1>
              <hr className="my_write_review_hr" style={{marginTop:20}}/>
              <div>
              {currentPosts(reviewsCount).map((reviewsCount,index)=>
                (<MyWriteReviewRow
                  homeStayReviewNum = {reviewsCount.homeStayReviewNum}
                  hostNum ={reviewsCount.homeStayNum}
                  hostName ={reviewsCount.hostName}
                  hostPhoto ={reviewsCount.homeStayPhoto}
                  content = {reviewsCount.content}
                  cleanliness = {reviewsCount.cleanliness}
                  communication = {reviewsCount.communication}
                  checkIn = {reviewsCount.checkIn}
                  accuracy = {reviewsCount.accuracy}
                  location = {reviewsCount.location}
                  Price = {reviewsCount.satisfactionForPrice}
                  photoNum = {reviewsCount.reviewPhotos}
                  photoName = {reviewsCount.reviewPhotos}
                  writeday = {reviewsCount.writeday}
                  key={index}
                />) 
                 )}
                 </div>
                <Pagination postsPerPage={postsPerPage} totalPosts={totalCount} paginate={setCurrentPage}  align="center"></Pagination>
          </div>

      );
}

export default  MyWriteReview;