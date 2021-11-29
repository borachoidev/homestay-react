import React from 'react';
import { withRouter } from 'react-router-dom';
import Button from '@material-ui/core/Button';

const MyReviewRow  =(props)=> {

    let date1= new Date();
    let date2= new Date(props.checkOut);
    let photo= `${props.housePhoto}`;
        return(
            <div className="myReview-Row"> 
              <div className="myReview-photo">
                  <img src={photo}/>
              </div>
              <div className="myReview-title">
                  <b>{props.title}</b>
                  <br/>
                  <br/>
                  <b>{props.checkIn}~{props.checkOut}</b>
              </div>
              {props.review===0 && date1 > date2
                     ? 
                     <Button className="review-button" variant="contained" color="primary" onClick={() => {
                        props.history.push(
                          `/mypage/review/${props.homeStayNum}/${props.ReservationNum}`
                        );
                      }}>리뷰작성</Button>
                     : (props.review===1
                     ?  <Button className="review-button" variant="contained" color="primary" disabled>작성 불가</Button>
                     : <Button className="review-button" variant="contained" color="primary" disabled>작성 불가</Button>
                     )
                    } 
            </div>
            
        );
    
}
export default withRouter(MyReviewRow);