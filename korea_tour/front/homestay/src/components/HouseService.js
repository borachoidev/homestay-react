import React from 'react';
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

function HouseService(props) {
    return (
        <div>
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
        </div>
    );
}

export default HouseService;