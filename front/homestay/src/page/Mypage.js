import React from 'react';
import { Link } from 'react-router-dom';
import { useTheme, makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

import "components/Mypage.css";

const Mypage  =()=> {
        return (
           <div className="mypage" style={{marginTop: 40}}>
           <h1>마이페이지</h1>
           <hr className="mypage_hr"/>
           <div className="mypage-btn" >
           <Link to="/mypage/reservation">
           <Button variant="contained" color="secondary">예약 내역</Button>
           </Link>
           <Link to="/mypage/like">
           <Button className="click-btn" color="default">내가 찜한 홈스테이</Button>
           </Link>
           <Link to="/mypage/review">
           <Button className="click-btn">리뷰쓰기</Button>
           </Link>
           <Link to="/mypage/myreview">
           <Button className="click-btn">내가 쓴 리뷰</Button>
           </Link>
           </div>
           </div>
        );
    
}
export default Mypage;