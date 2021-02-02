import React from 'react';
import { Route } from 'react-router-dom';
import Home from 'page/Home';
import HostForm from 'page/HostForm';
import HouseDetail from 'components/HouseDetail';
import ReservationConfirm from 'components/ReservationConfirm';

function RouteMain(props) {
  return (
    <div>
      <Route exact path="/homestay" component={Home} />
      <Route path="/homestay/apply" component={HostForm} />
      <Route path="/homestay/housedetail:num" component={HouseDetail} />
      <Route
        path="/homestay/reservationconfirm:num"
        component={ReservationConfirm}
      />
    </div>
  );
}

export default RouteMain;
