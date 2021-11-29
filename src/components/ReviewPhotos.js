import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { URL } from '_utils/api';
import { review } from '_utils/api';
import { useParams } from 'react-router-dom';

function ReviewPhotos(props) {

    const [content, setContent] = useState(null);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(null);

    let { houseNum } = useParams();
    const reviewNum = props.reviewNum;
   
    useEffect( () => {
        const getReviews = async (reviewNum) => {
            try {
                setContent(null);
                setError(null);
                setLoading(true);
                const response = await axios.get(
                    `${URL}/${houseNum}/allreview/${reviewNum}`
                );
                console.log(reviewNum)
                setContent(response.data.photos);
            } catch(e) {
                setError(e);
            }
            setLoading(false);
        };
        getReviews(reviewNum);
    }, []);

    if (loading) return <p>로딩중....</p>;
    if (error) return <p>에러가 발생했습니다.!!</p>;
    if (!content) return null;


    return (
        <div id="photoBox">
            {
                content.map((i,idx)=>{
                    
                    return (
                            <div key={i.photoNum}><img className="review-roomimg" src={i.photoName} /></div>
                        )
                    
                })
            }
        </div>
    );
}

export default ReviewPhotos;