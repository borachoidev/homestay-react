import React from 'react';
import Review from './Review';
import './HouseDetailCss/ReviewList.css';
import StarIcon from '@material-ui/icons/Star';

function ReviewList(props) {
    return (
        <div>
            <hr/>
            <br/>
            <h1>리뷰리스트</h1>
                <span id="star"><StarIcon color="error" /></span><span id="scoreText">4.94(후기 204개)</span>
            <div id="reviewList">
                <Review />
            
                <Review />
            
                <Review />

                <Review />
            
                <Review />
            
                <Review />
            </div>
            <br/>
            <hr/>
        </div>
        
    );
}

export default ReviewList;