import React, { useState, useEffect } from 'react';
import { URL } from '_utils/api';
import { useHistory, useParams } from 'react-router-dom';
import Button from '@material-ui/core/Button';
import axios from 'axios';
import 'components/hostBook.css';
import { Box } from '@material-ui/core';

function HostBookDetail(props) {
  let history = useHistory();
  let { num } = useParams();
  const bookNum = num.split('=')[1];
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    // async를 사용하는 함수 따로 선언
    const fatchData = async bookNum => {
      setLoading(true);
      try {
        const response = await axios.get(`${URL}/reservation/${bookNum}`);
        setData(response.data.detail);
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fatchData(bookNum);
  }, []);

  if (loading) {
    return <p>대기중....</p>;
  }
  //articles 값이 설정되지 않았을때
  if (!data) {
    return null;
  }
  // articles 값이 유효할때
  let appoval = data.appoval;

  return (
    <div className="container">
      <h1>예약자 정보</h1>
      <Box
        display="flex"
        flexDirection="row"
        justifyContent="space-around"
        className="info"
      >
        <div className="guestInfo">
          <h3>이름 </h3>
          {data.name} <h3>생년월일</h3>
          {data.birthYear}년{data.birthMonth}월 {data.birthDay}
          <h3>성별</h3>
          {data.gender == 'M' ? '남자' : '여자'}
          <h3>이메일</h3> {data.email1}@{data.email2}
        </div>
        <div className="bookInfo">
          <h3>체크인일자</h3>
          {data.checkInDay} <h3>체크아웃일자</h3> {data.checkOutDay}
          <h3>인원</h3>
          <span>{data.numberOfPeople} 명</span>
          <h3>금액</h3> <span>{data.totalPrice}원</span>
        </div>
      </Box>
      <Button
        type="button"
        onClick={history.goBack}
        variant="contained"
        color="secondary"
      >
        목록으로
      </Button>
    </div>
  );
}

export default HostBookDetail;
