import React from 'react';
import TextField from '@material-ui/core/TextField';

const MyWriteReviewRow = (props) => {
     
    let photo = props.photoName;
    console.log(photo);
    
    const photoList = photo.map(
        (photo,i) => (
            <div className="write_review_img">
            <img key={i} src={`${photo.photoName}`}/>
            </div> 
        )
    );
    return  (
          <div className="write_Row">
          <div className="write_hostInfo">
          <div className="write_host_img">
          <img src={`${props.hostPhoto}`} />    
          <b className="write_host_name">{props.hostName}</b> 
          <b className="write_day">{props.writeday}</b>  
          </div>
         
          <br/>
          <div className="write_review_img_list">
            {photoList}    
          </div>
          </div> 
           <div className="write_star">
           <b>청결도 :</b>{props.cleanliness}
           <b>의사소통 :</b>{props.communication}
           <b>체크인 :</b>{props.checkIn}
           <b>정확성 :</b>{props.accuracy}
           <b>위치 :</b>{props.location}
           <b>가격대비 만족도: </b>{props.Price}
           </div>
           <div className="write_content">
           <TextField
          id="outlined-read-only-input"
          label="review"
          value={props.content}
          InputProps={{
            readOnly: true,
          }}
          variant="outlined"
        />
               
           </div>
           
          </div>

      );
}

export default  MyWriteReviewRow;