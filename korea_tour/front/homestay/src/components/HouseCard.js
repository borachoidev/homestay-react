import React from "react";
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
import Heart from './Heart';
import Star from './Star';
import Button from '@material-ui/core/Button';

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
          <IconButton aria-label="add to favorites">
           <Heart />
          </IconButton>
        }
        title={props.title}
        
      />
      <CardMedia
        className={classes.media}
        image={props.url}
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
      <Button color="secondary">자세히보기>></Button>
      </CardActions>
    </Card>
  );
}