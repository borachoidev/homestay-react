import React, { useState } from "react";
import Toolbar from "@material-ui/core/Toolbar";
import Container from "@material-ui/core/Container";
import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";
import Box from "@material-ui/core/Box";
import { makeStyles } from "@material-ui/core/styles";
import TextField from '@material-ui/core/TextField';
import MenuItem from '@material-ui/core/MenuItem';

import { withRouter } from 'react-router-dom';


// const NavBar = () =>{

//   const [contents,setContents] = useState(null);
//   const [loading,setLoading] = useState(false);

// useEffect(() =>{
//   const fatchData = async ()=> {
//       setLoading(true);
//       try {
//           const response = await axios.get(
//               'http://localhost:9003//homestays/price/1'
//           );
//           setContents(response.data.list);
//           console.log(response.data.list);
          
//       } catch (e) {
//           console.log(e);
//       }
//       setLoading(false);
//   };
//   fatchData();
// }, []); 

// if (loading) {
//   return <p>대기중....</p>;
// }
// //articles 값이 설정되지 않았을때
// if (!contents) {
// return null;
// }
// // articles 값이 유효할때
// //<p>{contents[0].homeStayNum}</p>



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
  // const [state, changeState] = useState({
  //   keyword: "",
  //   maxPeople: "",
  //   checkInDay: "",
  //   checkOutDay:  "",
  //   });
  
  //   const handleKeyword = event => {
  //     const { target } = event;
  
  //     changeState(state => ({
  //       ...state,
  //       keyword: target.value
  //     }));
  //   };
  
  //   const handleEventMaxPeople = event => {
  //     const { target } = event;
  
  //     changeState(state => ({
  //       ...state,
  //       maxPeople: target.value
  //     }));
  //   };
  
  //   const handleCheckInDay = event => {
  //     const { target } = event;
  
  //     changeState(state => ({
  //       ...state,
  //       checkInDay: target.value
  //     }));
  //   };

  //   const handleOutDay = event => {
  //     const { target } = event;
  
  //     changeState(state => ({
  //       ...state,
  //       checkOutDay: target.value
  //     }));
  //   };
  
  //   const submitHandle = () => {
  //     const { keyword, maxPeople, checkInDay, checkOutDay } = state;
  //   }
  // };




  return (
        <div>
                {/* <form className="form-elements">
                  <input
                    value={state.name}
                    className="form-control form-inputs form-elements"
                    type="text"
                    onChange={handleName}
                    placeholder="user name"
                  />
                  <input
                    value={state.eventTitle}
                    className="form-control form-inputs form-elements"
                    type="text"
                    onChange={handleEventTitle}
                    placeholder="Event Title"
                  />
                  <input
                    value={state.details}
                    className="form-control form-inputs form-elements"
                    type="text"
                    onChange={handleDetails}
                    placeholder="Details "
                  />
                </form>
                 */}


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
          로고
        </Typography>
        <form className={classes.container} noValidate>
      
        <TextField
          label="장소"
          id="outlined-size-normal"
          defaultValue="Normal"
          variant="outlined"
        />
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

    <TextField
          label="인원"
          id="outlined-size-normal"
          defaultValue="Normal"
          variant="outlined"
        />
     
   </form>
        <Box className={classes.menuButtons}>
          {["호스트 신청", "홈", "마이페이지"].map((item) => (
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

          </div>
  );
          }