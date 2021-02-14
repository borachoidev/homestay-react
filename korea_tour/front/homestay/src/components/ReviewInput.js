import React, { useState } from 'react';
import { URL } from '_utils/api';

import store from '_store/Store';
import TextareaAutosize from '@material-ui/core/TextareaAutosize';
import IconButton from '@material-ui/core/IconButton';
import PhotoCamera from '@material-ui/icons/PhotoCamera';
import InputLabel from '@material-ui/core/InputLabel';

import './ReviewInput.css';

import StarRating from './AllStarRating';
import ReTextarea from './ReviewTextarea';
import ReviewFileUpload from './ReviewFileUpload';

const ReviewInput = () => {
  const [star, setStar] = useState({
    cleanliness: 0,
    communication: 0,
    checkIn: 0,
    accuracy: 0,
    location: 0,
    satisfactionForPrice: 0,
  });

  const [upload, setUpload] = useState({
    photo: '',
  });

  const [text, setText] = useState({
    content: '',
  });

  const writeReview = `${URL}/mypage/review`

  const goGo = () => {
    window.location.href=window.location.href;
  };

  let reviewUrl = window.location.href;
  let reviewHomestayNum = reviewUrl.split('/')[6];
  let ReservationNum = reviewUrl.split('/')[7];
  let loginNum = store.getState().userReducer.num;
  let loginId = store.getState().userReducer.name;
  let loginPhoto = store.getState().userReducer.avatar;

  return (
    <div style={{marginTop:30}}>
      <h1 className="input_review_title">리뷰쓰기</h1>
      <hr className="input_review_hr"></hr>
      <div className="input_review_form">
      <form
        action={writeReview}
        method="POST"
        enctype="multipart/form-data"
        target="iframe1"
      >
        <input
          type="hidden"
          name="homeStayReservationNum"
          value={ReservationNum}
        ></input>
        <input type="hidden" name="homeStayNum" value={reviewHomestayNum}></input>
        <input type="hidden" name="loginNum" value={loginNum}></input>
        <input type="hidden" name="loginPhoto" value={loginPhoto}></input>
        <input type="hidden" name="loginId" value={loginId}></input>

        <input type="hidden" name="cleanliness" value={star.cleanliness}></input>
        <input
          type="hidden"
          name="communication"
          value={star.communication}
        ></input>
        <input type="hidden" name="checkIn" value={star.checkIn}></input>
        <input type="hidden" name="accuracy" value={star.accuracy}></input>
        <input type="hidden" name="location" value={star.location}></input>
        <input
          type="hidden"
          name="satisfactionForPrice"
          value={star.satisfactionForPrice}
        ></input>

        <input type="hidden" name="photos" value={upload.photo}></input>

        <input type="hidden" name="text" value={text.content}></input>
        <div>
          <StarRating star={[star, setStar]} />
          <ReviewFileUpload />
        </div>
        <ReTextarea />
        <button type="submit" onClick={()=>{ alert("리뷰 작성 완료!!"); goGo() }}>리뷰작성</button>
        <iframe id="iframe1" name="iframe1" ></iframe>
      </form>
      
      </div>
    </div>
  );
};
export default ReviewInput;