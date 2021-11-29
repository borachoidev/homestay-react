import React, { useState, useEffect } from 'react';
import './HouseDetailCss/ReservationConfirm.css';
import store from '_store/Store';
import { URL } from '_utils/api';
import Button from '@material-ui/core/Button';

const ReservationConfirm=({ match }) => {
    
    const userNum = store.getState().userReducer.num;
    const homeStayNum = match.params.homeStayNum;
    const checkInDay = match.params.checkInDay;
    const checkOutDay = match.params.checkOutDay;
    const numberOfPeople = match.params.numberOfPeople;
    const price = match.params.totalPrice;
    
    const goHome = () => {
        window.location.href='/';
    }

    
    const totalPrice = parseInt(price);
    const priceWon = totalPrice.toLocaleString();
    

    console.log(price);
    console.log(priceWon);
    
    const postUrl = `${URL}/${homeStayNum}/reservation/guestdata`;
    

    return (
        <>
        <form action={postUrl} method="POST" target="iframe1">
            <div id="ReservationConfirm__mainBox">
            
                <div id="reservationPerson">
                    <h1>예약자 정보</h1>

                    <p>이름</p>
                    <input type="text" name="name" required/>

                    <p>전화번호</p>
                    <input type="text" placeholder="- 를 빼고 입력해주세요." name="hp" required/>

                    <p>이메일</p>
                    <input type="text" name="email1" required/><span> @ </span><input type="text" name="email2" required/>

                    <p>생년월일</p>
                    <input className="input-birth" type="number" name="birthYear" required/><span className="birth-text">년</span>
                    <input className="input-birth" type="number" name="birthMonth" required/><span className="birth-text">월</span>
                    <input className="input-birth" type="number" name="birthDay" required/><span className="birth-text">일</span>

                    <p>성별</p>
                    <input type="radio" name="gender" value="M" checked/>
                    <b>남자</b>
                    <input type="radio" name="gender" value="F" />
                    <b>여자</b>
                </div>

                <div id="reservationInfo">
                    <h1>예약 정보 확인</h1>
                    <p className="reservationInfo-text">체크인 : {checkInDay}</p>
                    <input type="hidden" name="checkInDay" value={checkInDay} />
                    
                    <p className="reservationInfo-text">체크아웃 : {checkOutDay}</p>
                    <input type="hidden" name="checkOutDay" value={checkOutDay} />

                    <p className="reservationInfo-text">인원수 : {numberOfPeople}명</p>
                    <input type="hidden" name="numberOfPeople" value={numberOfPeople} />

                    <p className="reservationInfo-text">총 가격 : ₩{priceWon}</p>
                    <input type="hidden" name="totalPrice" value={totalPrice} />

                    <input type="hidden" name="loginNum" value={userNum} />
                    <input type="hidden" name="homeStayNum" value={homeStayNum} />
                </div>

                
            </div>
            <div id="reservationBtn">
                <Button type="submit" variant="contained" color="primary" onClick={()=>{ alert("예약 신청 완료!!"); goHome() }}>예약 신청하기</Button>
                <iframe id="iframe1" name="iframe1" ></iframe>
            </div>
        </form>
        </>
    );
}

export default ReservationConfirm;