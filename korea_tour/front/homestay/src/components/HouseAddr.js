import React, { useState, useEffect } from 'react';
import axios from 'axios';
import RoomIcon from '@material-ui/icons/Room';
import { URL } from '_utils/api';
import { useParams } from 'react-router-dom';

function HouseAddr(props) {

    const [content, setContent] = useState(null);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(null);

    let { houseNum } = useParams();

    useEffect( () => {
        const getAddress = async () =>{
            try{
                setContent(null);
                setError(null);
                setLoading(true);
                const response = await axios.get(
                    `${URL}/${houseNum}/name`
                    );
                    setContent(response.data);
                    console.log(response.data);
            } catch (e){
                setError(e);
            }
            setLoading(false);
        };
        getAddress();
    }, []);

    if (loading) return <p>로딩중....</p>;
    if (error) return <p>에러가 발생했습니다.</p>;
    if (!content) return null;


    return (
        <div>
            <span>
                <span id="mapicon"><RoomIcon color="error" /></span>
                <span>{content.addr1}</span>
            </span>
        </div>
    );
}

export default HouseAddr;