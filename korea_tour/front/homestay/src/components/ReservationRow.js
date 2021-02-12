import React from 'react';
import { withRouter } from 'react-router-dom';




const ReservationRow  =(props)=> {
  let stayNum=props.homeStayNum;
        return (stayNum)
        ?
            <tr className="ReservationRow" onClick={() => {
                props.history.push(
                  `/mypage/reservation/${props.homeStayNum}/${props.approval}`
                );
              }}> 
                <th>{props.writeday}</th>
                <td>{props.title}</td>
                <th className="day_td">{props.checkIn}~{props.checkOut}</th>
                <th> 
                    {props.approval===0&&props.cancle===0
                     ? 
                     "예약대기"
                     : (props.approval===1||props.cancle===1
                     ? "예약취소"
                     :"예약승인")
                    } 
                </th>
            </tr>
          :(props==null
            ?
            <div>예약한 목록이 없습니다</div>
            :<div></div>)      
    
}
export default withRouter(ReservationRow);