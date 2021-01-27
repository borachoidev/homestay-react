import React from 'react';
import DetailInfoReservation from './DetailInfoReservation';
import DetailMap from './DetailMap';
import DetailPhotos from './DetailPhotos';
import HouseName from './HouseName';
import ReviewList from './ReviewList';


function HouseDetail(props) {
    return (
        <div>
            홈디테일
            {/* header */}

            {/* 집이름,즐겨찾기,별점 */}
            <HouseName />

            {/* 사진 DetailPhotos */}
            <DetailPhotos />
            
            {/* DetailInfoReservation */}
            <DetailInfoReservation />
                {/* DetailInfo */}
                    {/* HouseInfo */}
                    {/* HouseIntro */}
                    {/* HouseService */}
                {/* DetailReservation */}
                    {/* CalendarCheckIn */}
                    {/* AddPerson */}

            {/* ReviewList */}
            <ReviewList />
                {/* Review */}

            {/* DetailMap */}
            <DetailMap />
            
            

            {/* Footer */}
        </div>
    );
}

export default HouseDetail;