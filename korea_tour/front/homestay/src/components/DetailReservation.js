import React, { useState, useEffect } from 'react';
import AddPerson from './AddPerson';



function DetailReservation(props) {
    
    return (
        <div>
            <h3>인원 및 날짜 선택</h3>
                <div><AddPerson /></div>
                
        </div>
    );
}

export default DetailReservation;