import  React, { useState } from 'react';
import { URL } from '_utils/api';
import store from '_store/Store';
import axios from 'axios';

import IconButton from "@material-ui/core/IconButton";
import FavoriteIcon from '@material-ui/icons/Favorite';
import { pink } from '@material-ui/core/colors';

import { withRouter } from 'react-router-dom';

const ListRow  =(props)=> {

  const userNum = store.getState().userReducer.num;
  console.log(userNum)

  const DeleteMark = async () => {
    
    try {
      const response = await axios.delete(
        `${URL}/mark?homeStayNum=${props.homeNum}&userNum=${userNum}`,
        { data: { homeStayNum: props.homeNum, userNum: userNum} });
      console.log("삭제성공");
       
    } catch (e) {
      console.log(e);
      
    }
  };

  let image= `${props.photo}`;
    return (
      <div>
        <div className="like_list_List" onClick={() => {
            props.history.push(
              `/house/${props.homeNum}`
            );
          }}>
        <img className="like_list_Img" src={image}/>
        <div className="like_list_text">
        <b className="like_list_Home">{props.title}</b>
        <br/>
        <b className="like_list_Host">{props.hostName}</b>
        <br/>
        <b className="like_list_Addr">{props.addr}</b>
        <div className="like_list_Star">
        <b className="star_num">★ </b>
        <b className="star_avg_num">{props.star}</b>
        </div>
        </div>
        
          <div className="like_list_heart">
          <IconButton aria-label="add to favorites">
          <span onClick={DeleteMark}><FavoriteIcon style={{ color: pink[500] }} /></span>
          </IconButton>
          </div>
          </div>
      </div>
    );
}
export default withRouter(ListRow);