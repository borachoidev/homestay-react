import React from 'react';
import './../ProgressBar.css';

function ProgressBar(props) {
  return (
    <div className="progress">
      <ul>
        <li>
          <i className="fas fa-check-circle"></i>
          <span>호스트정보</span>
        </li>
        <li>
          <i className="fas fa-check-circle"></i>
          <span>숙소기본정보</span>
        </li>
        <li>
          <i className="fas fa-check-circle"></i>
          <span>편의시설</span>
        </li>
        <li>
          <i className="fas fa-check-circle"></i>
          <span>숙소소개</span>
        </li>
        <li>
          <i className="fas fa-check-circle"></i>
          <span>입력정보확인</span>
        </li>
      </ul>
    </div>
  );
}

export default ProgressBar;
