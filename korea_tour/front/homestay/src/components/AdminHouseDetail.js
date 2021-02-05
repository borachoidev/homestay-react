import React, { useEffect, useState } from 'react';
import { withRouter } from 'react-router-dom';
import AdminHouseInfo from './AdminHouseInfo';
import DetailMap from './DetailMap';
import DetailPhotos from './DetailPhotos';
import HouseName from './HouseName';
import Button from '@material-ui/core/Button';
import axios from 'axios';

const handleConfirm = async () => {
    try {
      const num = props.content.homeStayNum;
      console.log(num);
      const response = await axios.patch(
        `/admin/homestays/${num}/approve`
      );
      props.history.push(`http://localhost:9003/admin/homestays/1`);
    } catch (e) {
      console.log(e);
    }
  };

  const handleDeny = async () => {
    try {
      const num = props.content.homeStayNum;
      console.log(num);
      const response = await axios.patch(
        `/admin/homestays/${num}/deny`
      );
      props.history.push(`http://localhost:9003/admin/homestays/1`);
    } catch (e) {
      console.log(e);
    }
  };


function AdminHouseDetail(props) {
    return (
        <div>
           
            {/* header */}
            {/* HouseName -> AdminHouseName 으로 custom을 하였으나 custom시 HouseName이  최종본이 아니였음 수정필요 */}
            {/* 집이름,즐겨찾기,별점 */}
            <HouseName />
                <Button variant="contained" size="small" onClick={handleConfirm}>
                승인
                </Button>
                 <Button variant="contained" color="secondary" onClick={handleDeny}>
                거절
                </Button>
            {/* 사진 DetailPhotos */}
            <DetailPhotos />
            
           
             {/* DetailInfoReservation */}
             <AdminHouseInfo />

            {/* DetailMap */}
            <DetailMap />
            
            

            {/* Footer */}
        </div>
    );
}

export default AdminHouseDetail;