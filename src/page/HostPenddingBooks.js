import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { URL } from '_utils/api';
import MyBookRow from 'components/MyBookRow';
import store from '_store/Store';
import { makeStyles } from '@material-ui/core/styles';
import Pagination from '@material-ui/lab/Pagination';
import 'components/hostBook.css';
const useStyles = makeStyles(theme => ({
  root: {
    '& > *': {
      marginTop: theme.spacing(2),
    },
  },
}));

function HostPenddingBooks({ history }) {
  const [contents, setContents] = useState(null);
  const [loading, setLoading] = useState(false);
  const [totalPage, setTotalPage] = useState(1);
  const [currentPage, setCurrentPage] = useState(1);
  const num = store.getState().userReducer.num;
  const classes = useStyles();
  const fatchData = async (userNum, currentPage) => {
    //대기중인 예약일시 0
    const approval = 0;
    const url = `${URL}/reservation/${userNum}/${approval}/${currentPage}`;
    setLoading(true);
    try {
      const response = await axios.get(url);
      setTotalPage(response.data.totalPage);
      setContents(response.data.list);
      console.log(url);
      console.log(response.data.totalPage);
    } catch (e) {
      console.log(e);
    }
    setLoading(false);
  };
  useEffect(() => {
    fatchData(num, 1);
  }, []);

  if (loading) {
    return <p>대기중....</p>;
  }
  //articles 값이 설정되지 않았을때
  if (!contents) {
    return null;
  }
  // articles 값이 유효할때
  let appoval = contents.appoval;

  return (
    <div className="container">
      <h1>승인 대기 예약</h1>
      <table className="booking-table">
        <thead>
          <tr>
            <th className="guest">예약자</th>
            <th className="count">인원</th>
            <th className="check-in">체크인시간</th>
            <th className="check-out">체크아웃시간</th>
            <th colspan="2" className="manage">
              관리
            </th>
          </tr>
        </thead>
        <tbody>
          {contents.map(content => (
            <MyBookRow
              key={content.homeStayReservationNum}
              content={content}
              history={history}
            />
          ))}
        </tbody>
      </table>
      <div className={classes.root}>
        <Pagination
          count={totalPage}
          color="secondary"
          onChange={(e, number) => {
            fatchData(num, number);
            setCurrentPage(number);
          }}
          page={currentPage}
        />
      </div>
    </div>
  );
}

export default HostPenddingBooks;
