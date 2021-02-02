import React from 'react';
import { Route } from 'react-router-dom';
import Home from 'page/Home';
import HostFormApp from 'page/HostFormApp';
import HouseDetail from 'components/HouseDetail';
import ReservationConfirm from 'components/ReservationConfirm';
import ReviewForm from 'page/ReviewForm';
import ReservationList from 'page/ReservationList';
import ReservationDetail from 'page/ReservationDetail';

function RouteMain(props) {
  return (
    <div>
      <Route exact path="/homestay" component={Home} />
      <Route path="/homestay/apply" component={HostFormApp} />
      <Route path="/homestay/housedetail:num" component={HouseDetail} />
      <Route
        path="/homestay/reservationconfirm:num"
        component={ReservationConfirm}
      />
      <Route path="/homestay/mypage/reviewwrite" component={ReviewForm} />
      <Route
        path="/homestay/mypage/ReservationList"
        component={ReservationList}
      />
      <Route
        path="/homestay/mypage/Reservationdetail:num"
        component={ReservationDetail}
      />
    </div>
  );
}

export default RouteMain;
