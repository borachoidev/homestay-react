import React from 'react';
import FavoriteIcon from '@material-ui/icons/Favorite';
import StarIcon from '@material-ui/icons/Star';
import RoomIcon from '@material-ui/icons/Room';
import ShareIcon from '@material-ui/icons/Share';
import './HouseDetailCss/HouseName.css';

function HouseName(props) {
    return (
        <div>
            <h1>브레스 힐</h1>
            <div id="infoBox">
                <span>
                    <span id="star"><StarIcon color="error" /></span><span>4.94(204)</span>
                    <span id="mapicon"><RoomIcon color="error" /></span><span>Namwon-eup, 제주도, 한국</span>
                </span>
                <span>
                    <span id="share"><ShareIcon color="error"/></span>
                    <span id="favorite"><FavoriteIcon color="error" /></span>
                </span>
            </div>
        </div>
    );
}

export default HouseName;