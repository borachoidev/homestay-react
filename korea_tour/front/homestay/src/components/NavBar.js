import React, { useState } from "react";
import Toolbar from "@material-ui/core/Toolbar";
import Container from "@material-ui/core/Container";
import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";
import Box from "@material-ui/core/Box";
import { makeStyles } from "@material-ui/core/styles";
import TextField from '@material-ui/core/TextField';
import MenuItem from '@material-ui/core/MenuItem';
import AddPerson from './AddPerson';



const useStyles = makeStyles((theme) => ({

  toolbar: {
   
    display: "flex",
    flexDirection: "column",
    justifyContent: "space-between",
    alignItems: "center",
    padding: theme.spacing(3),
    marginBottom: theme.spacing(3),
    [theme.breakpoints.up("md")]: {
      flexDirection: "row",
      justifyContent: "space-between",
      alignItems: "flex-end",
      marginBottom: theme.spacing(9),
    },
  },
  toolbarTitle: {
    letterSpacing: 1.25,
    fontWeight: "bold",
  },
  menuButtons: {
    display: "flex",
    flexDirection: "column",
    [theme.breakpoints.up("md")]: {
      flexDirection: "row",
    },
  },
  item: {
    padding: theme.spacing(1),
    [theme.breakpoints.up("md")]: {
      paddingLeft: theme.spacing(3),
    },
    container: {
      display: 'flex',
      flexWrap: 'wrap',
    },
    textField: {
      marginLeft: theme.spacing(1),
      marginRight: theme.spacing(1),
      width: 100,
    },
  },
}));

export default function NavBar() {
  const classes = useStyles();
  const [activeBtn, setActiveBtn] = useState("destinations");



  return (
    <Container>
      <Toolbar className={classes.toolbar}>
        <Typography
          component="h2"
          variant="h5"
          color="inherit"
          align="left"
          noWrap
          className={classes.toolbarTitle}
        >
          로고를 여기에!
        </Typography>
        <form className={classes.container} noValidate>
      <TextField
        name="date"
        label="시작일"
        type="date"
        defaultValue="2017-05-24"
        className={classes.textField}
        InputLabelProps={{
          shrink: true,
        }}
      />
      <TextField
        name="date"
        label="종료일"
        type="date"
        defaultValue="2017-05-24"
        className={classes.textField}
        InputLabelProps={{
          shrink: true,
        }}
      />
      <AddPerson/>
   </form>
        <Box className={classes.menuButtons}>
          {["호스트 신청", "홈으로", "마이페이지"].map((item) => (
            <Link
              component="button"
              variant="body2"
              onClick={() => setActiveBtn(item)}
              color={activeBtn === item ? "textPrimary" : "textSecondary"}
              className={classes.item}
              key={item}
            >
              {item.toUpperCase()}
            </Link>
          ))}
        </Box>
       
      </Toolbar>
    </Container>
  );
}