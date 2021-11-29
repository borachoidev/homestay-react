import React, { useState, useEffect } from 'react';
import StarIcon from '@material-ui/icons/Star';
import axios from 'axios';
import { URL } from '_utils/api';
import { useParams } from 'react-router-dom';

function HouseStarAvg(props) {
    const [content, setContent] = useState(null);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(null);

    let { houseNum } = useParams();

    useEffect( () => {
        const getStar = async () =>{
            try{
                setContent(null);
                setError(null);
                setLoading(true);
                const response = await axios.get(
                    `${URL}/${houseNum}/star`
                    );
                    setContent(response.data);
                    console.log(response.data);
            } catch (e){
                setError(e);
            }
            setLoading(false);
        };
        getStar();
    }, []);

    if (loading) return <p>로딩중....</p>;
    if (error) return null;
    if (!content) return null;

    return (
        <div>
            <span>
                <span id="star"><StarIcon color="error" /></span><span>{content.allOfAvg}(후기 {content.countOfReview}개)</span>
            </span>
        </div>
    );
}

export default HouseStarAvg;