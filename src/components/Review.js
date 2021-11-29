import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './HouseDetailCss/Review.css';
import ReviewPhotos from './ReviewPhotos';
import { URL } from '_utils/api';
import { useParams } from 'react-router-dom';

function Review(props) {
    const [content, setContent] = useState(null);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(null);

    let { houseNum } = useParams();

    useEffect( () => {
        const getReviews = async () => {
            try {
                setContent(null);
                setError(null);
                setLoading(true);
                const response = await axios.get(
                    `${URL}/${houseNum}/allreview`
                );
                setContent(response.data.reviews);
            } catch(e) {
                setError(e);
            }
            setLoading(false);
        };
        getReviews();
    }, []);

    if (loading) return <p>로딩중....</p>;
    if (error) return null;
    if (!content) return null;

    

    return (
        <>
        {
                content.map((i,idx)=>{
                    if(idx<6){
                    return (
                        <>
                        {i.relevel==0?<div className="review-box">
                            
                            <div className="review-writer-box">
                                <div className="profile-box">
                                    <div className="profile-img"><img src={i.loginPhoto}/></div>
                                    <div className="writer-writeday">
                                        <p><b>{i.loginId}</b></p>
                                        <span className="guest-writeday">{i.writeday}</span>
                                    </div>
                                </div>
                                <div className="room-img"><ReviewPhotos reviewNum={i.homeStayReviewNum}/></div> 
                            </div>
                            <div className="review-text-box">
                                {i.content} 
                            </div>
                        </div>:null}
                        </>
                     )
                    }
                })
            }

        
        </>
    );
}

export default Review;