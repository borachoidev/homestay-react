import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import AccountCircle from '@material-ui/icons/AccountCircle';
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/Menu';
import GoogleButton from 'components/GoogleButton';
import KakaoButton from 'components/KakaoButton';
import NaverButton from 'components/NaverButton';
import Avatar from '@material-ui/core/Avatar';
import { connect } from 'react-redux';
import { signOut } from '_actions/user';
import store from '_store/Store';
import { Link, useHistory } from 'react-router-dom';
import Search from 'components/Search';
import logo from 'logo_white.png';

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
  logo: {
    width: 130,
    height: 60,
  },
  links: {
    fontFamily: 'regular',
    color: 'inherit',
    textDecoration: 'none',
  },
}));

const NavBar = ({ signOut }) => {
  const history = useHistory();
  const classes = useStyles();
  const auth = store.getState().userReducer.auth;
  const host = store.getState().userReducer.host;
  const avatar = store.getState().userReducer.avatar;
  const [anchorEl, setAnchorEl] = useState(null);
  const open = Boolean(anchorEl);
  const handleMenu = event => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };
  const logOut = () => {
    signOut();
    setAnchorEl(null);
    history.push('/');
    console.log('로그아웃');
  };

  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" className={classes.title}>
          <Link to="/">
            <img className={classes.logo} src={logo} />
          </Link>
        </Typography>
        <Search />
        {!auth && (
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
        {auth && (
          <div>
            <IconButton
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleMenu}
              color="inherit"
            >
              <Avatar alt="avatar" src={avatar} />
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
              <MenuItem onClick={handleClose}>
                <Link className={classes.links} to="/mypage">
                  마이페이지
                </Link>
              </MenuItem>
              {host == 'N' && (
                <MenuItem>
                  <Link className={classes.links} to="/apply">
                    호스트되기{' '}
                  </Link>
                </MenuItem>
              )}
              {host == 'Y' && (
                <MenuItem onClick={handleClose}>
                  <Link className={classes.links} to="/host/manage/house">
                    호스트관리
                  </Link>
                </MenuItem>
              )}
              <MenuItem className={classes.links} onClick={logOut}>
                로그아웃
              </MenuItem>
            </Menu>
          </div>
        )}
      </Toolbar>
    </AppBar>
  );
};

export default connect(null, dispatch => ({
  signOut: () => dispatch(signOut()),
}))(NavBar);
