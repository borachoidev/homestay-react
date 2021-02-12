import React, { useEffect, useState } from 'react';
import axios from 'axios';
import store from '_store/Store';
import { URL } from '_utils/api';

import "components/ReservationList.css";
import Row from "components/ReservationRow";
import Pagination from 'components/Pagination';

const ReservationList =()=>{
    const [list,setList] = useState(null);
    const [loading,setLoading] = useState(false);

    const [currentPage, setCurrentPage] = useState(1);
    const [postsPerPage, setPostsPerPage] = useState(10);

    let loginNum=store.getState().userReducer.num;
    console.log(loginNum);


    const yesData = async ()=> {
        try {
            const response = await axios.get(
                `${URL}/mypage/reservations/approved/${loginNum}`
            );
            setList(response.data);
            console.log(response.data.reservations);
        } catch (e) {
            console.log(e);
        }
    };

    const waitData = async ()=> {
        try {
            const response = await axios.get(
                `${URL}/mypage/reservations/wating/${loginNum}`
            );
            setList(response.data);
            console.log(response.data.reservations);
        } catch (e) {
            console.log(e);
        }
    };  

    const cancleData = async ()=> {
        try {
            const response = await axios.get(
                `${URL}/mypage/reservations/cancel/${loginNum}`
            );
            setList(response.data);

        } catch (e) {
            console.log(e);
        }
    };

    const fatchData = async ()=> {
        try {
            const response = await axios.get(
                `${URL}/mypage/reservations/all/${loginNum}`
            );
            setList(response.data);
        } catch (e) {
            console.log(e);
        }
    };
 
    useEffect(() =>{
    // async를 사용하는 함수 따로 선언
    const fatchData = async ()=> {
        setLoading(true);
        try {
            const response = await axios.get(
                `${URL}/mypage/reservations/all/${loginNum}`
            );
            setList(response.data);
            console.log(response.data.reservations);
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
    if (!list) {
     return null;
    }
     // articles 값이 유효할때
    
     const indexOfLast = currentPage * postsPerPage;
     const indexOfFirst = indexOfLast - postsPerPage;
     function currentPosts(tmp) {
       let currentPosts = 0;
       currentPosts = tmp.slice(indexOfFirst, indexOfLast);
       return currentPosts;
     }

    
     let appoval = list.appoval;
     let listData = list.reservations
        return (
            <div className="reservation">
                
                    <div className="data_btn">
                    <h1>예약확인</h1>
                    <button onClick={cancleData}>예약취소</button>
                    <button onClick={waitData}>예약대기</button>
                    <button onClick={yesData}>예약승인</button>
                    <button onClick={fatchData}>전체보기</button>
                    </div>
                <table className="reservationTable">
                    
                    <thead>
                        <tr>
                        <th id="writeDay">예약 날짜</th>
                        <th id="homestayName">장소</th>
                        <th id="day">숙박기간</th>
                        <th id="approval">승인 현황</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        {currentPosts(list.reservations).map((listData,index)=>
                            (<Row
                            homeStayNum = {listData.homeStayReservationNum}
                            writeday = {listData.writeday}
                            title = {listData.homeTitle}
                            checkIn = {listData.checkInDay}
                            checkOut = {listData.checkOutDay}
                            approval = {listData.approval}
                            cancle ={listData.deleted}
                            key ={index}
                            />)
                            )}
                        <Row/>
                    </tbody>
                </table>

                {/* 페이징 처리 */}
                {list.totalCount>1
                ?
                <Pagination postsPerPage={postsPerPage} totalPosts={list.totalCount} paginate={setCurrentPage}  align="center"></Pagination>
                :<Pagination postsPerPage={postsPerPage} totalPosts={9} paginate={1}  align="center"></Pagination>}
            </div>
        )
}

export default ReservationList;