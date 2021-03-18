import React, { useEffect } from 'react';
import { BrowserRouter } from 'react-router-dom';
import RouteMain from './RouteMain';
import NavBar from 'page/NavBar';

import './App.css';
function App() {
  return (
    <React.Fragment>
      <BrowserRouter basename="/homestay">
        <NavBar />
        <div className="Route">
          <RouteMain />
        </div>
      </BrowserRouter>
    </React.Fragment>
  );
}

export default App;
