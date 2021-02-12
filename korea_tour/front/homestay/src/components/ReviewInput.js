import React, { useState } from 'react';
import axios from 'axios';

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

  let reviewUrl = window.location.href;
  let reviewHomestayNum = reviewUrl.split('/')[6];
  let ReservationNum = reviewUrl.split('/')[7];
  let loginNum = store.getState().userReducer.num;
  let loginId = store.getState().userReducer.name;
  let loginPhoto = store.getState().userReducer.avatar;

  return (
    <div>
      <form
        action="http://localhost:9003/homestays/mypage/review"
        method="POST"
        enctype="multipart/form-data"
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

        <input type="hidden" name="text        " value={text.content}></input>
        <div>
          <StarRating star={[star, setStar]} />
          <ReviewFileUpload />
        </div>
        <ReTextarea />
        <button type="submit">리뷰작성</button>
      </form>
    </div>
  );
};
export default ReviewInput;