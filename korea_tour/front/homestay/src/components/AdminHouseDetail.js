import React, { useEffect, useState } from 'react';
import { URL } from '_utils/api';
import { withRouter } from 'react-router-dom';
import DetailInfo from './DetailInfo';
import DetailMap from './DetailMap';
import DetailPhotos from './DetailPhotos';
import HouseName from './HouseName';
import HouseAddr from './HouseAddr';
import Button from '@material-ui/core/Button';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles(theme => ({
  
  adminBtns:{
    fontFamily: 'regular',
    backgroundColor:'#00A699',
    fontSize: '13px'
    
    
  },
  

    
}));


function AdminHouseDetail({match,history}) {
  const classes = useStyles();
  let {houseNum}=useParams()
  
  const handleConfirm = async () => {
    try {
      const url=`${URL}/admin/${houseNum}/approve`
      console.log(url);
      const response = await axios.patch(
        url
      ).then(res=>{console.log(res)});
      console.log("승인완료")
       
    } catch (e) {
      console.log(e);
    }
  };

  const handleDeny = async () => {
    try {
     
      console.log(houseNum);
      const response = await axios.patch(
        `${URL}/admin/${houseNum}/deny`
      );
      console.log("거절완료")
    } catch (e) {
      console.log(e);
    }
  };

    return (
        <div>
           
            {/* header */}
  
            {/* 집이름,즐겨찾기,별점 */}
            <HouseName /> 
            <HouseAddr /> <br></br>
                <Button className={classes.adminBtns} onClick={handleConfirm} >
                승인 
                </Button > {'   '}
                 <Button className={classes.adminBtns} onClick={handleDeny}>
                거절
                </Button>
            {/* 사진 DetailPhotos */}
            <DetailPhotos />

             {/* DetailInfoReservation */}
             <DetailInfo />

            {/* DetailMap */}
            <DetailMap />
            
            {/* Footer */}
        </div>
    );
}

export default AdminHouseDetail;