import React from 'react';
import axios from 'axios';
function HostMyBooks(props) {
  const getData = (userNum, currentPage) => {
    axios
      .get(
        `https://localhost:9003/homestay/reservation/${userNum}/1/${currentPage}`
      )
      .then(response => {
        console.log(response.data);
      });
  };
  getData(10, 1);
  return <div>호스트 승인된 예약</div>;
}

export default HostMyBooks;
