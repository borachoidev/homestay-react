import React from 'react';
import './HouseDetailCss/Review.css';

function Review(props) {
    return (
        
        <div className="review-box">
            <div className="review-writer-box">
                <div className="profile-box">
                    <div className="profile-img"></div>
                    <div className="writer-writeday">
                        <p><b>작성자</b></p>
                        <p>2021년 1월</p>
                    </div>
                </div>

                <div className="room-img"></div>
            </div>
        
            <div className="review-text-box">
                리뷰리뷰리뷰리뷰리뷰리뷰 리뷰리뷰리뷰리뷰리뷰 리뷰리뷰리뷰리뷰리뷰 
            </div>
        </div>
    );
}

export default Review;