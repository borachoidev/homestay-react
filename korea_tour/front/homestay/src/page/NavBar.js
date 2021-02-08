import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { connect } from 'react-redux';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import AccountCircle from '@material-ui/icons/AccountCircle';
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/Menu';
import GoogleButton from 'components/GoogleButton';
import KakaoButton from 'components/KakaoButton';
import NaverButton from 'components/NaverButton';
import Avatar from '@material-ui/core/Avatar';
import store from '_store/Store';

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

const NavBar = ({ auth }) => {
  const classes = useStyles();
  const [logged, setLogged] = useState(false);
  const [anchorEl, setAnchorEl] = useState(null);
  const [user, setUser] = useState({
    num: '',
    avatar: '',
    name: '',
    host: 0,
    auth: false,
  });
  const open = Boolean(anchorEl);

  const handleMenu = event => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  store.subscribe(() => {
    console.log('user subscribe()', store.getState().userReducer);
    setUser({
      num: store.getState().userReducer.num,
      avatar: store.getState().userReducer.avatar,
      name: store.getState().userReducer.name,
      host: store.getState().userReducer.host,
      auth: store.getState().userReducer.auth,
    });
  });

  return (
    <AppBar>
      <Toolbar>
        <Typography variant="h6" className={classes.title}>
          라온 홈스테이
        </Typography>
        {!user.auth && (
          <div>
            <IconButton
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleMenu}
              color="inherit"
            >
              <AccountCircle />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorEl}
              anchorOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              open={open}
              onClose={handleClose}
            >
              <MenuItem>
                <KakaoButton />
              </MenuItem>
              <MenuItem>
                <NaverButton />
              </MenuItem>
              <MenuItem>
                <GoogleButton />
              </MenuItem>
            </Menu>
          </div>
        )}
        {user.auth && (
          <div>
            <IconButton
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleMenu}
              color="inherit"
            >
              <Avatar alt="avatar" src={user.avatar} />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorEl}
              anchorOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              open={open}
              onClose={handleClose}
            >
              <MenuItem onClick={handleClose}>마이페이지</MenuItem>
              {user.host == 'N' && (
                <MenuItem onClick={handleClose}>호스트되기</MenuItem>
              )}
            </Menu>
          </div>
        )}
      </Toolbar>
    </AppBar>
  );
};

export default NavBar;
