import React, { useEffect, useState } from 'react';
import { withRouter, useParams } from 'react-router-dom';
import axios from 'axios';
import Grid from '@material-ui/core/Grid';
import HouseCard from './HouseCard';
import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import HouseListSort from './HouseListSort';
import Button from '@material-ui/core/Button';
//import Pagination2 from './Pagination2';
import store from '_store/Store';

const HouseListFeatured = () => {
  const [contents, setContents] = useState(null);
  const [loading, setLoading] = useState(false);
  const userNum = store.getState().userReducer.num;
  console.log(userNum);
  let { area, checkin, checkout, guest } = useParams();

  useEffect(() => {
    const data = {
      keyword: area,
      maxPeople: guest,
      checkInDay: checkin,
      checkOutDay: checkout,
      userNum: userNum,
    };
    console.log(data);
    const fatchData = async () => {
      setLoading(true);
      try {
        const response = await axios.post(
          'http://localhost:9003/homestays/price/1',
          data
        );
        setContents(response.data.list);
        console.log(response.data.list);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fatchData();
  }, [area, checkin, checkout, guest]);

  if (loading) {
    return <p>대기중....</p>;
  }
  //articles 값이 설정되지 않았을때
  if (!contents) {
    return null;
  }

  const byCost = async () => {
    const data = {
      keyword: area,
      maxPeople: guest,
      checkInDay: checkin,
      checkOutDay: checkout,
      userNum: userNum,
    };
    try {
      const response = await axios.post(
        `http://localhost:9003//homestays/price/1`,
        data
      );
      setContents(response.data.list);
      console.log('성공');
    } catch (e) {
      console.log(e);
    }
  };

  const byStars = async () => {
    const data = {
      keyword: area,
      maxPeople: guest,
      checkInDay: checkin,
      checkOutDay: checkout,
      userNum: userNum,
    };
    try {
      const response = await axios.post(
        `http://localhost:9003//homestays/review/1`,
        data
      );
      setContents(response.data.list);
      console.log('성공2');
    } catch (e) {
      console.log(e);
    }
  };
  // articles 값이 유효할때
  return (
    <div>
      {
        <Grid container spacing={3}>
          <Grid item xs={12}>
            <HouseListSort />
            <Button variant="contained" size="small" onClick={byCost}>
              요금순
            </Button>
            &nbsp;&nbsp;
            <Button
              variant="contained"
              color="secondary"
              size="small"
              id="orderByStars"
              onClick={byStars}
            >
              평점순
            </Button>
          </Grid>

          {contents.map(content => (
            <Grid item xs={6} sm={4} md={4} key={content}>
              <HouseCard
                photoName={content.photoName}
                title={content.title}
                addr1={content.addr1}
                price={content.price}
                countOfReview={content.countOfReview}
                avgOfStar={content.avgOfStar}
                homeStayNum={content.homeStayNum}
              />
            </Grid>
          ))}
        </Grid>
      }
      {/*<Pagination2 /> */}
    </div>
  );
};

export default HouseListFeatured;
