import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import CardActions from "@material-ui/core/CardActions";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import FavoriteIcon from "@material-ui/icons/Favorite";
import ShareIcon from "@material-ui/icons/Share";
import MoreVertIcon from "@material-ui/icons/MoreVert";
import Rating from '@material-ui/lab/Rating';
import Box from '@material-ui/core/Box';

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

  return (
    <Card className={classes.root}>
      <CardHeader
        action={
          <IconButton aria-label="add to favorites" id="Liked">
            <FavoriteIcon />
          </IconButton>
        }
        title="무슨무슨 집입니다 오세요"
        
      />
      <CardMedia
        className={classes.media}
        image={props.url}
        title="자세히 보러가기"
      />
      <CardContent>
        <Typography variant="body2" color="textSecondary" component="p">
          이러이러하구요
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        
      <Box component="fieldset" mb={3} borderColor="transparent">
        <Typography component="legend">4.6(6)</Typography>
        <Rating name="read-only" value="4" readOnly />
      </Box>
      </CardActions>
    </Card>
  );
}