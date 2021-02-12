import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { URL } from '_utils/api';
import { useParams } from 'react-router-dom';

function HouseCheckInOut(props) {

    const [content, setContent] = useState(null);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(null);

    let { houseNum } = useParams();

    useEffect( () => {
        
        const getHouseInfoTime = async () => {
            try {
                setContent(null);
                setError(null);
                setLoading(true);
                const response = await axios.get(
                    `${URL}/${houseNum}/hosttime`
                );
                setContent(response.data);
            } catch(e) {
                setError(e);
            }
            setLoading(false);
        };
        getHouseInfoTime();
    }, []);

   
    if (loading) return <p>로딩중....</p>;
    if (error) return <p>에러가 발생했습니다.!!</p>;
    if (!content) return null;

    return (
        <div>
            {content.checkIn2=="0"?<p>Check-In : {content.checkIn1}시</p>:<p>Check-In : {content.checkIn1}시 {content.checkIn2}분</p>}
            {content.checkOut2=="0"?<p>Check-Out : {content.checkOut1}시</p>:<p>Check-Out : {content.checkOut1}시 {content.checkOut2}분</p>}
        </div>
    );
}

export default HouseCheckInOut;