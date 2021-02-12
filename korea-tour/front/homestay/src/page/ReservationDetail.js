import React,{ useEffect }  from 'react';
import axios from 'axios';
import { URL } from '_utils/api';

import ReservationContent from "components/ReservationContent";
import ReservationButton from "components/ReservationButton";
import ReservationHostInfo from "components/ReservationHostInfo";
import "components/ReservationDetail.css";
const ReservationDetail = () =>{
  let reservationUrl = window.location.href;
  let reservationNum = reservationUrl.split('/')[6];
  console.log(reservationNum);

  const cancelRe = async () => {
  try {
    const response = await axios.patch(
      `${URL}/mypage/reservation/customer/cancel/${reservationNum}`
    ,{});
    alert("예약이 취소되었습니다.");

     
  } catch (e) {
    console.log(e);
    
   }
  };
    return (
        <div className="reservation_all">
          <b className="detail_text">예약상세</b>
          <ReservationHostInfo/>
          <ReservationContent/>
          <ReservationButton 
           patchNum={cancelRe}/>
        </div>
    )
}


export default ReservationDetail;