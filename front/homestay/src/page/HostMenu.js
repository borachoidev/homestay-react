import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import SwipeableDrawer from '@material-ui/core/SwipeableDrawer';
import Button from '@material-ui/core/Button';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import HouseIcon from '@material-ui/icons/House';
import MenuIcon from '@material-ui/icons/Menu';
import PanToolIcon from '@material-ui/icons/PanTool';
import PlaylistAddCheckIcon from '@material-ui/icons/PlaylistAddCheck';
import { Link } from 'react-router-dom';

const useStyles = makeStyles({
  list: {
    width: 250,
  },
  fullList: {
    width: 'auto',
  },
});

export default function HostMenu() {
  const classes = useStyles();
  const [state, setState] = React.useState({
    top: false,
  });

  const toggleDrawer = (anchor, open) => event => {
    if (
      event &&
      event.type === 'keydown' &&
      (event.key === 'Tab' || event.key === 'Shift')
    ) {
      return;
    }

    setState({ ...state, [anchor]: open });
  };

  return (
    <div>
      <Button onClick={toggleDrawer('bottom', true)}>
        <MenuIcon />
        menu
      </Button>
      <SwipeableDrawer
        anchor="bottom"
        open={state['bottom']}
        onClose={toggleDrawer('bottom', false)}
        onOpen={toggleDrawer('bottom', true)}
      >
        <div
          className="bottom"
          role="presentation"
          onClick={toggleDrawer('bottom', false)}
          onKeyDown={toggleDrawer('bottom', false)}
        >
          <List>
            <Link to="/host/manage/house">
              <ListItem button>
                <ListItemIcon>
                  <HouseIcon />
                </ListItemIcon>
                <ListItemText primary="홈스테이관리" />
              </ListItem>
            </Link>
            <Link to="/host/manage/books">
              <ListItem button>
                <ListItemIcon>
                  <PanToolIcon />
                </ListItemIcon>
                <ListItemText primary="대기중인예약" />
              </ListItem>
            </Link>
            <Link to="/host/books">
              <ListItem button>
                <ListItemIcon>
                  <PlaylistAddCheckIcon />
                </ListItemIcon>
                <ListItemText primary="승인된예약" />
              </ListItem>
            </Link>
          </List>
          <Divider />
        </div>
      </SwipeableDrawer>
    </div>
  );
}
