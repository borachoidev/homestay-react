import React from 'react';
import { img,review } from '_utils/api';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
  root: {
    '& .MuiTextField-root': {
      margin: theme.spacing(1),
      width: '60vw',
    },
  },
}));

const MyWriteReviewRow = (props) => {
     
    let photo = props.photoName;
    console.log(photo);
    const classes = useStyles();
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
          <div className="write_review_img_list">
            {photoList}    
          </div>
          </div> 
           <div className="write_star">
           <b>청결도 :</b>{props.cleanliness.toFixed(1)}
           <b>의사소통 :</b>{props.communication.toFixed(1)}
           <b>체크인 :</b>{props.checkIn.toFixed(1)}
           <b>정확성 :</b>{props.accuracy.toFixed(1)}
           <b>위치 :</b>{props.location.toFixed(1)}
           <b>가격대비 만족도: </b>{props.Price.toFixed(1)}
           </div>
           <form className={classes.root,"write_content"}>
           <TextField
          id="outlined-read-only-input"
          label="review"
          defaultValue={props.content}
          InputProps={{
            readOnly: true,
          }}
          variant="outlined"
        />
               
           </form>
           
          </div>

      );
}

export default  MyWriteReviewRow;