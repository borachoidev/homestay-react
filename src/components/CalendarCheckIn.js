import { addDays } from 'date-fns';
import React, { useState, useEffect } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { ko } from 'date-fns/esm/locale';
import Button from '@material-ui/core/Button';
import { Link } from 'react-router-dom';
import store from '_store/Store';
import axios from 'axios';
import { URL } from '_utils/api';
import { useParams } from 'react-router-dom';

function CalendarCheckIn(props) {
  const [content, setContent] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const linkurl = document.location.href;
  const homeStayNum = linkurl.split('=')[1];
  let { houseNum } = useParams();

  const userNum = store.getState().userReducer.num;
  console.log('유저넘:' + userNum);

  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(addDays(new Date(), 1));
  const day1 = new Date(startDate);
  const day2 = new Date(endDate);

  const checkIndayYear = day1.getFullYear();
  const checkIndayMonth = day1.getMonth() + 1;
  const checkIndayDate = day1.getDate();

  const checkOutdayYear = day2.getFullYear();
  const checkOutdayMonth = day2.getMonth() + 1;
  const checkOutdayDate = day2.getDate();

  const checkInday = `${checkIndayYear}-${
    checkIndayMonth < 10 ? '0' + checkIndayMonth : checkIndayMonth
  }-${checkIndayDate < 10 ? '0' + checkIndayDate : checkIndayDate}`;
  const checkOutday = `${checkOutdayYear}-${
    checkOutdayMonth < 10 ? '0' + checkOutdayMonth : checkOutdayMonth
  }-${checkOutdayDate < 10 ? '0' + checkOutdayDate : checkOutdayDate}`;

  const numberOfPeople = props.count;
  const housePrice = props.price;

  const oneNight = `${
    (day2 - day1) / (1000 * 60 * 60 * 24) < 1
      ? 1
      : (day2 - day1) / (1000 * 60 * 60 * 24)
  }`;
  // console.log(oneNight+"박");
  // console.log(housePrice+"원");
  // console.log(day2);
  // console.log(day1)
  const totalCost = Math.ceil(oneNight) * housePrice;
  const totalCostWon = '₩' + totalCost.toLocaleString();

  useEffect(() => {
    const getReviews = async () => {
      try {
        setContent(null);
        setError(null);
        setLoading(true);
        const response = await axios.get(`${URL}/${houseNum}/calendar`);
        setContent(response.data.day);
      } catch (e) {
        setError(e);
      }
      setLoading(false);
    };
    getReviews();
  }, []);

  if (!content) return null;

  // let testnear = [3,5,15,20,21,24];
  // let nearDay1;
  // for(var i=0; i<testnear.length; i++){
  //     if(15 < testnear[i]){
  //         nearDay1 = testnear[i];
  //         break;
  //     }
  // }

  //선택한 날중 가장 가까운날짜  갓보라 그저 빛
  let nearDay;
  for (var i = 0; i < content.length; i++) {
    if (startDate < new Date(content[i].checkInDay)) {
      nearDay = new Date(content[i].checkInDay);
      break;
    }
  }

  console.log('시작날짜: ' + startDate);
  console.log('nearDay: ' + nearDay);

  const reservationDay = date => {
    if (content.length > 0) {
      let reserDay = new Array(content.length);
      for (let i = 0; i < content.length; i++) {
        reserDay[i] = [
          addDays(new Date(content[i].checkInDay), -1),
          new Date(content[i].checkOutDay),
        ];
      }

      let booked =
        reserDay[0][0] > new Date(date) || new Date(date) > reserDay[0][1];
      for (let i = 1; i < content.length; i++) {
        booked =
          (booked && reserDay[i][0] > new Date(date)) ||
          new Date(date) > reserDay[i][1];
      }
      return booked;
    } else {
      let s =
        new Date('2050-11-30') > new Date(date) ||
        new Date(date) > new Date('2050-12-31');
      return s;
    }
  };
  console.log('reservationDay: ' + reservationDay());

  return (
    <>
      체크인 :{' '}
      <DatePicker
        locale={ko}
        dateFormat="yyyy-MM-dd"
        selected={startDate}
        onChange={date => setStartDate(date)}
        selectsStart
        startDate={startDate}
        endDate={endDate}
        minDate={new Date()}
        placeholderText="날짜를 선택해 주세요"
        className="startDay-input"
        filterDate={reservationDay}
      />
      <br />
      체크아웃 :{' '}
      <DatePicker
        locale={ko}
        dateFormat="yyyy-MM-dd"
        selected={endDate}
        onChange={date => setEndDate(date)}
        selectsEnd
        startDate={startDate}
        endDate={endDate}
        minDate={addDays(startDate, 1)}
        maxDate={addDays(nearDay, -1)}
        placeholderText="날짜를 선택해 주세요"
        className="endDay-input"
        filterDate={reservationDay}
      />
      <div id="totalCostBox">
        <span>
          ₩{housePrice.toLocaleString()} x {Math.ceil(oneNight)}박
        </span>
        <hr className="cost-hr" />
        <div className="totalcost-box">
          <span>
            <b>총 합계 {totalCostWon}</b>
          </span>
        </div>
      </div>
      {userNum === 0 ? (
        <h3 className="login-ok">예약하시려면 로그인을 해주세요!!</h3>
      ) : (
        <Link
          to={
            '/reservation/' +
            userNum +
            '/' +
            houseNum +
            '/' +
            checkInday +
            '/' +
            checkOutday +
            '/' +
            numberOfPeople +
            '/' +
            totalCost +
            ''
          }
          style={{ textDecoration: 'none' }}
        >
          <Button variant="contained" color="primary" className="reser-btn">
            예약하기
          </Button>
        </Link>
      )}
    </>
  );
}

export default CalendarCheckIn;
