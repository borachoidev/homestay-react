import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { URL } from '_utils/api';
import { useParams } from 'react-router-dom';
import HouseCheckInOut from './HouseCheckInOut';

function HouseInfo(props) {
    const [content, setContent] = useState(null);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(null);

    let { houseNum } = useParams();

    useEffect( () => {
        const getHouseInfo = async () => {
            try {
                setContent(null);
                setError(null);
                setLoading(true);
                const response = await axios.get(
                    `${URL}/${houseNum}/hostname`
                );
                setContent(response.data);
            } catch(e) {
                setError(e);
            }
            setLoading(false);
        };
       
        getHouseInfo();
    }, []);

   
    if (loading) return <p>로딩중....</p>;
    if (error) return <p>에러가 발생했습니다.!!</p>;
    if (!content) return null;
    
    return (
        <div>
            <h1 id="HostId">
                    {content.name}님이 호스팅하는 집
                </h1>
                <hr/>

                <p className="info-title"><b>집 전체</b></p>
                <p className="info-text">게스트용 별채 전체를 단독으로 사용하시게 됩니다.</p>
                <br/>

                <p className="info-title"><b>청결 강화</b></p>
                <p className="info-text">코로나19 시대에 라온나들이가 전문가와 함께 개발한 기준인 강화된 5단계 청소 절차를 준수하겠다고 동의한 호스트입니다.</p>
                <br/>

                <p className="info-title"><b>셀프 체크인</b></p>
                <p className="info-text">키패드를 이용해 체크인하세요.</p>
                <br/>

                <p className="info-title"><b>환불 정책</b></p>
                <p className="info-text">체크인 30일 전까지 취소하시면 전액이 환불됩니다.</p>
                <br/>

                <p className="info-title"><b>숙소 이용규칙</b></p>
                <HouseCheckInOut />
               
                <div className="space"></div>
                <hr/>
                

                
        </div>
    );
}

export default HouseInfo;