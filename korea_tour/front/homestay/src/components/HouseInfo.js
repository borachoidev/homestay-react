import React from 'react';

function HouseInfo(props) {
    return (
        <div>
            <h1 id="HostId">
                    Climb님이 호스팅하는 집
                </h1>
                <hr/>

                <p><b>집 전체</b></p>
                <p>주택 전체를 단독으로 사용하시게 됩니다.</p>
                <br/>

                <p><b>청결 강화</b></p>
                <p>에어비앤비의 강화된 5단계 청소 절차를 준수하겠다고 동의한 호스트입니다.</p>
                <br/>

                <p><b>셀프 체크인</b></p>
                <p>열쇠 보관함을 이용해 체크인하세요.</p>
                <br/>

                <p><b>환불 정책</b></p>
                <p>체크인 30일 전까지 취소하시면 전액이 환불됩니다.</p>
                <br/>

                <p><b>숙소 이용규칙</b></p>
                <p>반려동물 동반이나 흡연이 금지되는 숙소입니다.</p>
                <br/>
                <hr/>
                <br/>

                
        </div>
    );
}

export default HouseInfo;