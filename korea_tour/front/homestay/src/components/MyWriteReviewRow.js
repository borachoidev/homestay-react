import React, { useEffect, useState } from 'react';
import { img,review } from '_utils/api';


const MyWriteReviewRow = (props) => {
     
    let photo = props.photoName;
    console.log(photo);
    /*let photoUrl =`http://localhost:9003/homeStayReviewImg/`+props.reviewPhotos.photoName
    
    {photo.map((photo)=>
                (<img src={"http://localhost:9003/homeStayReviewImg/"+photo.photoName}></img>) 
                 )}*/
    const photoList = photo.map(
        (photo,i) => (
            <div className="write_review_img">
            <img key={i} src={`${review}/${photo.photoName}`}/>
            </div> 
        )
    );
    return (
          <div className="write_Row">
          <div className="write_hostInfo">
          <div className="write_host_img">
          <img src={`${img}/${props.hostPhoto}`} />    
          <b className="write_host_name">{props.hostName}</b> 
          <b className="write_day">{props.writeday}</b>  
          </div>
         
          <br/>
          
            {photoList}    
          
          </div> 
           
           <b className="write_star">청결도 :</b>{props.cleanliness.toFixed(1)}
           <b className="write_star">의사소통 :</b>{props.communication.toFixed(1)}
           <b className="write_star">체크인 :</b>{props.checkIn.toFixed(1)}
           <b className="write_star">정확성 :</b>{props.accuracy.toFixed(1)}
           <b className="write_star">위치 :</b>{props.location.toFixed(1)}
           <b className="write_star">가격대비 만족도: </b>{props.Price.toFixed(1)}
           <div className="write_content">
               {props.content}
           </div>
           
          </div>

      );
}

export default  MyWriteReviewRow;