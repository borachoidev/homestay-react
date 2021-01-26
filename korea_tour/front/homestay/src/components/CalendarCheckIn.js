import React, { useState, useEffect } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";



function CalendarCheckIn(props) {
    const [startDate, setStartDate] = useState(new Date());
    
    return (
        <>
            <DatePicker selected={startDate} onChange={date => setStartDate(date)} locale="ko" />
      
        </>
    );
}

export default CalendarCheckIn;