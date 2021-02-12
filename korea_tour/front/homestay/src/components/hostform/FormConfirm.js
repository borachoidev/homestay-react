import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import PetsIcon from '@material-ui/icons/Pets';
import SmokingRoomsIcon from '@material-ui/icons/SmokingRooms';
import SmokeFreeIcon from '@material-ui/icons/SmokeFree';
import LocalParking from '@material-ui/icons/LocalParking';
import OfflineBolt from '@material-ui/icons/OfflineBolt';
import Kitchen from '@material-ui/icons/Kitchen';
import EmojiFoodBeverage from '@material-ui/icons/EmojiFoodBeverage';
import AcUnit from '@material-ui/icons/AcUnit';
import Wc from '@material-ui/icons/Wc';
import Bathtub from '@material-ui/icons/Bathtub';
import Wifi from '@material-ui/icons/Wifi';

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`vertical-tabpanel-${index}`}
      aria-labelledby={`vertical-tab-${index}`}
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
    id: `vertical-tab-${index}`,
    'aria-controls': `vertical-tabpanel-${index}`,
  };
}

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
    display: 'flex',
    height: 224,
    width: '75%',
    margin: 'auto',
  },
  tabs: {
    borderRight: `1px solid ${theme.palette.divider}`,
  },
}));

export default function FormConfirm(props) {
  const hostInfo = props.info;
  const houseIntro = props.intro;
  const [amenities, setAmenities] = props.amenity;
  const houseRules = props.rules;
  const classes = useStyles();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div className={classes.root}>
      <Tabs
        orientation="vertical"
        variant="scrollable"
        value={value}
        onChange={handleChange}
        aria-label="Vertical tabs example"
        className={classes.tabs}
      >
        <Tab label="호스트정보" {...a11yProps(0)} />
        <Tab label="숙소정보" {...a11yProps(1)} />
        <Tab label="홈스테이소개" {...a11yProps(2)} />
      </Tabs>
      <TabPanel value={value} index={0}>
        <h3>주소</h3>
        <p>
          {hostInfo.addr1}
          {hostInfo.addr2}
        </p>
        <h3>이메일</h3>
        <p>
          {hostInfo.email1}@{hostInfo.email2}
        </p>
        <h3>연락처</h3>
        <p>{hostInfo.hp}</p>
      </TabPanel>
      <TabPanel value={value} index={1}>
        <p>
          <h3>체크인 시간 </h3> {houseRules.checkIn1} 시
          {houseRules.checkIn2 == 0 ? '' : houseRules.checkIn2 + '분'}
        </p>
        <p>
          <h3>체크아웃 시간 </h3>
          {houseRules.checkOut1} 시
          {houseRules.checkOut2 == 0 ? '' : houseRules.checkOut2 + '분'}
        </p>
        <h3>편의시설</h3>
        <Box display="flex" justifyContent="space-around" flexWrap="wrap">
          {amenities.dogOk ? (
            <span>
              <PetsIcon />
              반려동물동반
            </span>
          ) : (
            ''
          )}
          {amenities.wifi ? (
            <span>
              <Wifi /> 무선인터넷(wifi)
            </span>
          ) : (
            ''
          )}
          {amenities.smokingOk ? (
            <span>
              <SmokingRoomsIcon />
              흡연 가능
            </span>
          ) : (
            <span>
              {' '}
              <SmokeFreeIcon /> 금연 숙소
            </span>
          )}
          {amenities.bathroom ? (
            <span>
              <Wc /> 개별화장실
            </span>
          ) : (
            ''
          )}
          {amenities.parking ? (
            <span>
              <LocalParking /> 주차시설
            </span>
          ) : (
            ''
          )}
          {amenities.towel ? (
            <span>
              <Bathtub /> 욕실용품
            </span>
          ) : (
            ''
          )}
          {amenities.breakfast ? (
            <span>
              <EmojiFoodBeverage /> 조식제공
            </span>
          ) : (
            ''
          )}
          {amenities.aircon ? (
            <span>
              <AcUnit /> 에어컨
            </span>
          ) : (
            ''
          )}
          {amenities.elecProduct ? (
            <span>
              <OfflineBolt /> 가전제품
            </span>
          ) : (
            ''
          )}
          {amenities.kitchen ? (
            <span>
              <Kitchen /> 주방이용
            </span>
          ) : (
            ''
          )}
        </Box>
      </TabPanel>
      <TabPanel value={value} index={2}>
        <h3>하우스명</h3>

        <span> {houseIntro.title}</span>

        <h3>소개내용</h3>

        <p>{houseIntro.content}</p>
      </TabPanel>
    </div>
  );
}
