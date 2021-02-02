import React, { useContext } from 'react';
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
import { HostContext } from 'HostContext';
export default function FormAmenities() {
  const { amenities, setAmenities } = useContext(HostContext);

  const handleChange = event => {
    setAmenities({ ...amenities, [event.target.name]: event.target.checked });
  };

  return (
    <FormGroup column="true">
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.petAllow}
            icon={<PetsOutlinedIcon />}
            checkedIcon={<PetsIcon />}
            name="petAllow"
            onClick={handleChange}
          />
        }
        label="반려동물동반"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.smoking}
            icon={<SmokeFreeIcon />}
            checkedIcon={<SmokingRoomsIcon />}
            name="smoking"
            onClick={handleChange}
          />
        }
        label="흡연가능"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.wifiService}
            icon={<WifiOff />}
            checkedIcon={<Wifi />}
            name="wifiService"
            onClick={handleChange}
          />
        }
        label="무선인터넷(Wifi)"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.bathAmenity}
            icon={<BathtubOutlined />}
            checkedIcon={<Bathtub />}
            name="bathAmenity"
            onClick={handleChange}
          />
        }
        label="욕실용품"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.breakfast}
            icon={<EmojiFoodBeverageOutlined />}
            checkedIcon={<EmojiFoodBeverage />}
            name="breakfast"
            onClick={handleChange}
          />
        }
        label="조식제공"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.ac}
            icon={<AcUnitOutlined />}
            checkedIcon={<AcUnit />}
            name="ac"
            onClick={handleChange}
          />
        }
        label="에어컨"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.elect}
            icon={<OfflineBoltOutlined />}
            checkedIcon={<OfflineBolt />}
            name="elect"
            onClick={handleChange}
          />
        }
        label="가전제품"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.useKitchen}
            icon={<KitchenOutlined />}
            checkedIcon={<Kitchen />}
            name="useKitchen"
            onClick={handleChange}
          />
        }
        label="주방이용"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.restroom}
            icon={<WcOutlined />}
            checkedIcon={<Wc />}
            name="restroom"
            onClick={handleChange}
          />
        }
        label="개별화장실"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={amenities.parking}
            icon={<LocalParkingOutlined />}
            checkedIcon={<LocalParking />}
            name="parking"
            onClick={handleChange}
          />
        }
        label="주차시설"
      />
    </FormGroup>
  );
}
