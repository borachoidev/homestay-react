import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { URL } from '_utils/api';


const ReservationHostInfo = () => {
    
    const [hostInfo,setHostInfo] = useState(null);
    const [loading,setLoading] = useState(false);
    
    let reservationUrl = window.location.href;
    let reservationNum = reservationUrl.split('/')[6];

    useEffect(() =>{
    // async를 사용하는 함수 따로 선언
    const fatchData = async ()=> {
        setLoading(true);
        try {
            const response = await axios.get(
                `${URL}/mypage/reservation/detail/homeStay/summary/${reservationNum}`
            );
            setHostInfo(response.data);
            console.log(response.data)
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
   if (!hostInfo) {
    return null;
   }
   let photo= `${hostInfo.photoName}` ;
   // articles 값이 유효할때 
    return (
          <div className="reservation_host_info"  style={{ marginTop: 20 }}>
            <img className="reservation_host_img" src={photo}/>
            <div className="reservation_info-text">
            <p className="host_title"><b>장소명: </b>{hostInfo.homeTitle}</p>
            <br/>
            <p className="host_name"><b>호스트명: </b>{hostInfo.hostName}</p>
            <br/>
            <p className="host_addr"><b>주소: </b>{hostInfo.addr1}</p>
            </div>
          </div>

      );
}

export default ReservationHostInfo;