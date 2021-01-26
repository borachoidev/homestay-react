import React from 'react';
import AddPerson from './AddPerson';
import CalendarCheckIn from './CalendarCheckIn';
import './HouseDetailCss/DetailInfo.css';
import Button from '@material-ui/core/Button';
import LocalParking from '@material-ui/icons/LocalParking'; //주차
import OfflineBolt from '@material-ui/icons/OfflineBolt'; //가전제품
import Kitchen from '@material-ui/icons/Kitchen'; //주방이용
import EmojiFoodBeverage from '@material-ui/icons/EmojiFoodBeverage'; //조식제공
import AcUnit from '@material-ui/icons/AcUnit'; //에어컨
import Wc from '@material-ui/icons/Wc'; //개별화장실
import Bathtub from '@material-ui/icons/Bathtub'; //욕실용품
import Wifi from '@material-ui/icons/Wifi'; //와이파이
import PetsIcon from '@material-ui/icons/Pets'; //반려동물동반
import SmokingRoomsIcon from '@material-ui/icons/SmokingRooms'; //흡연
import SmokeFreeIcon from '@material-ui/icons/SmokeFree'; //금연
import { Link } from 'react-router-dom';

function DetailInfoReservation(props) {
    return (
        <>
        <div id="DetailInfo-Reservation">
            <div id="DetailInfo-MainBox">
                <h1 id="HostId">
                    Climb님이 호스팅하는 집
                </h1>
                <hr/>

                <p><b>집 전체</b></p>
                <p>주택 전체를 단독으로 사용하시게 됩니다.</p>
                <br/>

                <p><b>청결 강화</b></p>
                <p>에어비앤비의 강화된 5단계 청소 절차를 준수하겠다고 동의한 호스트입니다.</p>
                <br/>

                <p><b>셀프 체크인</b></p>
                <p>열쇠 보관함을 이용해 체크인하세요.</p>
                <br/>

                <p><b>환불 정책</b></p>
                <p>체크인 30일 전까지 취소하시면 전액이 환불됩니다.</p>
                <br/>

                <p><b>숙소 이용규칙</b></p>
                <p>반려동물 동반이나 흡연이 금지되는 숙소입니다.</p>
                <br/>
                <hr/>
                <br/>

                <h1>House 소개글</h1>
                <hr/>
                <br/>

                <h1>편의시설</h1>
                    <div id="InfoIcon">
                        <p><span><LocalParking color="error" /></span>주차</p>
                        <p><span><OfflineBolt color="error" /></span>가전제품</p>
                        <p><span><Kitchen color="error"/></span>주방이용</p>
                        <p><span><EmojiFoodBeverage color="error"/></span>조식제공</p>
                        <p><span><AcUnit color="error"/></span>에어컨</p>
                        <p><span><Wc color="error"/></span>개별화장실</p>
                        <p><span><Bathtub color="error"/></span>욕실용품</p>
                        <p><span><Wifi color="error"/></span>와이파이</p>
                        <p><span><PetsIcon color="error"/></span>반려동물동반</p>
                        <p><span><SmokingRoomsIcon color="error"/></span>흡연</p>
                        <p><span><SmokeFreeIcon color="error"/></span>금연</p>
                    </div>

                
                <br/>
            </div>







            <div id="Reservation-MainBox">
                <h3>요금을 확인하려면 날짜를 입력하세요</h3>
                <div><CalendarCheckIn /></div>
                <div><AddPerson /></div>
                <Link to="/reservationconfirm" style={{ textDecoration: 'none' }}>
                    <Button variant="contained" color="secondary">
                        예약하기
                    </Button>
                </Link>
            </div>
        </div>
        </>
    );
}

export default DetailInfoReservation;