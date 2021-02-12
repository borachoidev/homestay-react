import React from 'react';
import { Link } from 'react-router-dom';
import { useTheme, makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

import "components/Mypage.css";

const Mypage  =()=> {
        let mypageUrl = window.location.href;
        let mypageMain = mypageUrl.split('/mypage')[1];
        console.log(mypageMain)
        return (
           <div className="mypage" style={{marginTop: 40}}>
           <b className="mypage_h1">마이페이지</b>
           <hr className="mypage_hr"/>
           <div className="mypage-btn" >
           <Link to="/mypage/reservation">
           <button className="click-btn">예약 내역</button>
           </Link>
           <Link to="/mypage/like">
           <button className="click-btn">내가 찜한 홈스테이</button>
           </Link>
           <Link to="/mypage/review">
           <button className="click-btn">리뷰쓰기</button>
           </Link>
           <Link to="/mypage/myreview">
           <button className="click-btn">내가 쓴 리뷰</button>
           </Link>
           </div>
           {mypageMain
           ?
           <div></div>
           :
           <p className="mypage_title"><b>상단 버튼을 클릭</b>하여 확인하실 정보를 선택해주세요</p>
           
        }
           
           </div>
        );
    
}
export default Mypage;