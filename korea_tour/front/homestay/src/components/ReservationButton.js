import React from 'react';

import { Link } from 'react-router-dom';
import { useTheme, makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import ListIcon from '@material-ui/icons/List';
import EventBusyIcon from '@material-ui/icons/EventBusy';




const useStyles = makeStyles((theme) => ({
  button: {
    margin: theme.spacing(1),
  },
  root: ({ secondary }) => ({
    backgroundColor: secondary.main,
    widht: "50px",
    height: "50px",
  }),
}));



export default function ReservationButton(props) {
  const { palette } = useTheme();
  const classes = useStyles({
    secondary: palette.secondary
  });
  return (
    <div>
  
    <Button
      variant="contained"
      color="secondary"
      className={classes.button,classes.root}
      startIcon={<ListIcon />}
    >
       <Link to="/mypage/reservation"> 
      목록으로
      </Link>
    </Button>
    <Button
     variant="contained"
     color="secondary"
     className={classes.button,classes.root}
     startIcon={<EventBusyIcon />}
     onClick={props.patchNum}
    >
      예약취소
      </Button>
  </div>
  );
}
