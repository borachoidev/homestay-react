import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import CardActions from "@material-ui/core/CardActions";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import ShareIcon from "@material-ui/icons/Share";
import MoreVertIcon from "@material-ui/icons/MoreVert";
import Box from '@material-ui/core/Box';
import Star from './Star';
import Button from '@material-ui/core/Button';
import FavoriteIcon from '@material-ui/icons/Favorite';
import FavoriteBorderIcon from '@material-ui/icons/FavoriteBorder';
import { pink } from '@material-ui/core/colors';
import HouseListSort from './HouseListSort';
import { withRouter } from 'react-router-dom';

function UpdateMark(num){
   
  console.log(num)
  useEffect(() =>{
  // async를 사용하는 함수 따로 선언
  const axios = require('axios')
  axios.post('http://localhost:9003/homestays/mark?homeStayNum='+num
  ).then(function(response){
    console.log(response);
  });

},
[])};


function DeleteMark(num){
 
useEffect(() =>{
  // async를 사용하는 함수 따로 선언
  const axios = require('axios')
  axios.delete('http://localhost:9003/homestays/mark?homeStayNum='+num
  ).then(function(response){
    console.log(response);
  });
},

  [])};



const useStyles = makeStyles(() => ({
  root: { maxwidth: 365 },
  media: {
    height: 0,
    paddingTop: "56.25%",
  },
}));

export default function HouseCard(props) {
  const classes = useStyles();
  const [value, setValue] = React.useState(2);
  const [state, setState] = useState(true);

  return (
    <Card className={classes.root}>
      <CardHeader
        action={
          <IconButton aria-label="add to favorites">
           <div onClick={function toggle() {
            setState(!state);
            }}>
             {state ? <span onClick={()=>UpdateMark(props.homeStayNum)}><FavoriteBorderIcon /></span> : <span onClick={()=>DeleteMark(props.homeStayNum)}><FavoriteIcon style={{ color: pink[500] }} /></span>}
            </div> 
          </IconButton>
        }
        title={props.title}

      />
      <CardMedia
        className={classes.media}
      />
      <CardContent>
        <Typography variant="body2" color="textSecondary" component="p">
         
        </Typography>
        <Star /> 
         <Box component="fieldset" mb={3} borderColor="transparent">
         <Typography id="rate" variant="legend" color="textSecondary" component="p">
        4.6</Typography>
         <Typography component="legend" id="reviewCnt" color="textSecondary">(6)</Typography>
         <Typography component="legend" id="price" color="textSecondary">10,000원</Typography>
        </Box>
      </CardContent>
      <CardActions disableSpacing>
      <Button color="secondary" onClick={() => {
        props.history.push(
        `/homestay/housedetail:${props.homeStayNum}` )
      }}>자세히보기>></Button>
      </CardActions>
    </Card>
  );
}
