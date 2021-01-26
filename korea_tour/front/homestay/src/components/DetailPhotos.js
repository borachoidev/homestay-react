import React from 'react';
import './HouseDetailCss/DetailPhotos.css';

function DetailPhotos(props) {
    return (
        <>
            <div id="photosMainBox">
                <div id="photoLeftBox"></div>

                <div id="photoRightBox">
                    <div id="photoRightBox-left">
                        <div className="photo-mini-Box"></div>
                        <div className="photo-mini-Box"></div>
                    </div>

                    <div id="photoRightBox-right">
                        <div className="photo-mini-Box"></div>
                        <div className="photo-mini-Box"></div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default DetailPhotos;