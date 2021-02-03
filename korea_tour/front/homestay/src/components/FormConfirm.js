import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import PetsIcon from '@material-ui/icons/Pets';
import PetsOutlinedIcon from '@material-ui/icons/PetsOutlined';
import SmokingRoomsIcon from '@material-ui/icons/SmokingRooms';
import SmokeFreeIcon from '@material-ui/icons/SmokeFree';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import LocalParking from '@material-ui/icons/LocalParking';
import LocalParkingOutlined from '@material-ui/icons/LocalParkingOutlined';
import OfflineBolt from '@material-ui/icons/OfflineBolt';
import OfflineBoltOutlined from '@material-ui/icons/OfflineBoltOutlined';
import Kitchen from '@material-ui/icons/Kitchen';
import KitchenOutlined from '@material-ui/icons/KitchenOutlined';
import EmojiFoodBeverage from '@material-ui/icons/EmojiFoodBeverage';
import EmojiFoodBeverageOutlined from '@material-ui/icons/EmojiFoodBeverageOutlined';
import AcUnit from '@material-ui/icons/AcUnit';
import AcUnitOutlined from '@material-ui/icons/AcUnitOutlined';
import Wc from '@material-ui/icons/Wc';
import WcOutlined from '@material-ui/icons/WcOutlined';
import Bathtub from '@material-ui/icons/Bathtub';
import BathtubOutlined from '@material-ui/icons/BathtubOutlined';
import WifiOff from '@material-ui/icons/WifiOff';
import Wifi from '@material-ui/icons/Wifi';

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box p={3}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
  },
}));

export default function FormConfirm(props) {
  const [value, setValue] = React.useState(0);

  const hostInfo = props.info;
  const FormHouseIntro = props.intro;
  const amenities = props.amenity;
  const houseRules = props.rules;
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div>
      <AppBar position="static">
        <Tabs
          value={value}
          onChange={handleChange}
          aria-label="simple tabs example"
        >
          <Tab label="호스트정보" {...a11yProps(0)} />
          <Tab label="Item Two" {...a11yProps(1)} />
          <Tab label="Item Three" {...a11yProps(2)} />
        </Tabs>
      </AppBar>
      <TabPanel value={value} index={0}>
        {hostInfo.addr1}
        {hostInfo.addr2}
        {hostInfo.email1}@{hostInfo.email2}
        {hostInfo.hp}
      </TabPanel>
      <TabPanel value={value} index={1}>
        {houseRules.checkIn}
        {houseRules.checkOut}
      </TabPanel>
      <TabPanel value={value} index={2}>
        Item Three
      </TabPanel>
    </div>
  );
}
