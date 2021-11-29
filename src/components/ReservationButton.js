import React from 'react';
import { URL } from '_utils/api';
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

const reservationListUrl =`/mypage/reservation`

export default function ReservationButton(props) {
  const { palette } = useTheme();
  const classes = useStyles({
    secondary: palette.secondary
  });

  let reservationUrl = window.location.href;
  let reservationNum = reservationUrl.split('/')[7];
  return (
    <div className="reservation_deteil_btn">
  
    <Button
      variant="contained"
      color="secondary"
      className={classes.button,classes.root}
      startIcon={<ListIcon />}
    >
       <Link to={reservationListUrl}> 
      목록으로
      </Link>
    </Button>
    {reservationNum==2
    ?
    <Button
    variant="contained"
    disabled
    className={classes.button,classes.root}
    startIcon={<EventBusyIcon />}
    onClick={props.patchNum}
   >
     예약취소
     </Button>
     :
     <Button
    variant="contained"
    color="secondary"
    className={classes.button,classes.root}
    startIcon={<EventBusyIcon />}
    onClick={props.patchNum}
   >
     예약취소
     </Button>
     }
    
  </div>
  );
}
