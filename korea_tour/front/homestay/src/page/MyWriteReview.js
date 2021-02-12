import React, { useEffect, useState } from 'react';
import axios from 'axios';
import store from '_store/Store';
import { URL } from '_utils/api';

import MyWriteReviewRow from 'components/MyWriteReviewRow';
import 'components/MyWriteReview.css'
const  MyWriteReview = () => {
    
    const [myReview,setMyReview] = useState(null);
    const [loading,setLoading] = useState(false);
    
    let loginNum=store.getState().userReducer.num;
      console.log(loginNum);

    useEffect(() =>{
    // async를 사용하는 함수 따로 선언
    const fatchData = async ()=> {
        setLoading(true);
        try {
            const response = await axios.get(
                `${URL}/mypage/reviews/${loginNum}/1`
            );
            setMyReview(response.data.reviews);
            console.log(response.data.reviews);
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
   // articles 값이 유효할때 
    return (
          <div style={{marginTop:30}}>
              <h1 className="my_write_review_main">내가 쓴 리뷰</h1>
              <hr className="my_write_review_hr" style={{marginTop:20}}/>
              {myReview.map((myReview,index)=>
                (<MyWriteReviewRow
                  homeStayReviewNum = {myReview.homeStayReviewNum}
                  hostNum ={myReview.homeStayNum}
                  hostName ={myReview.hostName}
                  hostPhoto ={myReview.homeStayPhoto}
                  content = {myReview.content}
                  cleanliness = {myReview.cleanliness}
                  communication = {myReview.communication}
                  checkIn = {myReview.checkIn}
                  accuracy = {myReview.accuracy}
                  location = {myReview.location}
                  Price = {myReview.satisfactionForPrice}
                  photoNum = {myReview.reviewPhotos}
                  photoName = {myReview.reviewPhotos}
                  writeday = {myReview.writeday}
                  key={index}
                />) 
                 )}
          </div>

      );
}

export default  MyWriteReview;