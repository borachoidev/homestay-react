import React from 'react';
import { Route } from 'react-router-dom';
import Home from 'page/Home';
import HostForm from 'page/HostForm';
import HouseDetail from 'components/HouseDetail';

function RouteMain(props) {
  return (
    <div>
      <Route exact path="/homestay" component={Home} />
      <Route path="/homestay/apply" component={HostForm} />
      <Route path="/homestay/housedetail:num" component={HouseDetail} />
    </div>
  );
}

export default RouteMain;
