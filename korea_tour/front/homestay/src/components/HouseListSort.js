import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Typography from "@material-ui/core/Typography";
import Grid from "@material-ui/core/Grid";
import Button from '@material-ui/core/Button';

const useStyles = makeStyles((theme) => ({
  mainFeatured: {
    height: 180,
    backgroundColor: theme.palette.grey[900],
    color: theme.palette.common.white,
    marginBottom: theme.spacing(4),
    backgroundImage: "url(https://source.unsplash.com/oGl9C2wW3T0/6016x4016)",
    backgroundSize: "cover",
    backgroundRepeat: "no-repeat",
    backgroundPosition: "center",
  },
  mainFeaturedContent: {
    position: "relative",
    padding: theme.spacing(5),
    [theme.breakpoints.up("md")]: {
      padding: theme.spacing(6),
      paddingRight: 0,
    },
  },
  button: {
    marginRight: theme.spacing(6),
  }
}));

export default function HouseListSort() {
  const classes = useStyles();

  return (
    <Grid container className={classes.mainFeatured}>
      <Grid item md={6} className={classes.mainFeaturedContent}>
        <Typography component="h1" variant="h5" color="inherit" gutterBottom>
          근처 숙소들 :)
          <br/>
        </Typography>
        

        <div className={classes.button}>
        <Button variant="contained" size="small" id="orderByCost">요금순</Button>&nbsp;&nbsp;
        <Button variant="contained" color="secondary" size="small" id="orderByStars">평점순</Button>
        </div>
      </Grid>
    </Grid>
  );
}