import React, {useState} from 'react';
import axios from 'axios';

import store from '_store/Store';
import TextareaAutosize from '@material-ui/core/TextareaAutosize';
import IconButton from '@material-ui/core/IconButton';
import PhotoCamera from '@material-ui/icons/PhotoCamera';
import InputLabel from '@material-ui/core/InputLabel';

import "./ReviewInput.css"

import StarRating from './AllStarRating';
import ReTextarea from './ReviewTextarea';
import ReviewFileUpload from './ReviewFileUpload';


const ReviewInput = () => {
    const [star,setStar] = useState({
        clean: 0,
        communicate:0,
        checkIn:0,
        accuracy:0,
        location:0,
        contentment:0,
        
        
    })
    
    const [upload,setUpload] = useState({
        photo: '',
        
    })

    const [text,setText]= useState({
        content:'',
    })
    
    let reviewUrl = window.location.href;
    let reviewHomestayNum = reviewUrl.split('/')[6];
    let ReservationNum = reviewUrl.split('/')[7];
    let loginNum = store.getState().userReducer.num;
    let loginId = store.getState().userReducer.name;
    let loginPhoto = store.getState().userReducer.avatar;

        return (
            <div>
                <form action="http://localhost:9003/homestays/mypage/review" method="POST" enctype="multipart/form-data">
                <input type="text" name="homeStayReservationNum" value={ReservationNum}></input>
                <input type="text" name="homeStayNum" value={reviewHomestayNum}></input>
                <input type="text" name="loginNum" value={loginNum}></input>
                <input type="text" name="loginPhoto" value={loginPhoto}></input>
                <input type="text" name="loginId" value={loginId}></input>

                <input type="text" name="cleanliness" value={star.clean}></input>
                <input type="text" name="communication" value={star.communicate}></input>
                <input type="text" name="checkIn" value={star.checkIn}></input>
                <input type="text" name="accuracy" value={star.accuracy}></input>
                <input type="text" name="location" value={star.location}></input>
                <input type="text" name="satisfactionForPrice" value={star.contentment}></input>

                <input type="text" name="photos" value={upload.photo}></input>

                <input type="text" name="loginId" value={text.content}></input>
                <div>
                <StarRating />
                <ReviewFileUpload/>
                </div>
               <ReTextarea/>
                <button type="submit">리뷰작성</button>
                </form>
            </div>
        );
    }
export default ReviewInput;