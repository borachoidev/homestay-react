import React from 'react';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';
import FormAmenities from 'components/hostform/FormAmenities';

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
    display: 'flex',
    width: '65%',
    flexDirection: 'column',
    margin: 'auto',
  },
  input: {
    width: '13.8vw',
  },
}));
export default function FormHouseRules(props) {
  const classes = useStyles();
  const [houseRules, setHouseRules] = props.rules;
  const handleChange = event => {
    setHouseRules({
      ...houseRules,
      [event.target.name]: event.target.value,
    });
  };

  return (
    <div className={classes.root}>
      <div>
        <TextField
          id="checkInHour"
          label="체크인 시"
          type="number"
          name="checkIn1"
          value={houseRules.checkIn1}
          inputProps={{ placeholder: '1', min: '1', max: '24' }}
          InputLabelProps={{
            shrink: true,
          }}
          onChange={handleChange}
          className={classes.input}
        />
        <TextField
          id="checkInMins"
          label="체크인 분"
          type="number"
          step="15"
          name="checkIn2"
          value={houseRules.checkIn2}
          inputProps={{ placeholder: '0', step: '15', min: '0', max: '45' }}
          InputLabelProps={{
            shrink: true,
          }}
          onChange={handleChange}
          className={classes.input}
        />

        <TextField
          id="checkOutHour"
          label="체크아웃 시"
          type="number"
          name="checkOut1"
          value={houseRules.checkOut1}
          inputProps={{ placeholder: '1', min: '1', max: '24' }}
          InputLabelProps={{
            shrink: true,
          }}
          onChange={handleChange}
          className={classes.input}
        />
        <TextField
          id="checkOutMins"
          label="체크아웃 분"
          type="number"
          step="15"
          name="checkOut2"
          value={houseRules.checkOut2}
          inputProps={{ placeholder: '0', step: '15', min: '0', max: '45' }}
          InputLabelProps={{
            shrink: true,
          }}
          onChange={handleChange}
          className={classes.input}
        />
      </div>
      <TextField
        id="price"
        label="가격"
        type="number"
        name="price"
        inputProps={{ placeholder: '10000', min: '0', step: '10' }}
        value={houseRules.price}
        InputLabelProps={{
          shrink: true,
        }}
        onChange={handleChange}
      />
      <TextField
        id="maxPeople"
        label="수용인원"
        type="number"
        name="maxPeople"
        inputProps={{ placeholder: '1', min: '1' }}
        value={houseRules.maxPeople}
        InputLabelProps={{
          shrink: true,
        }}
        onChange={handleChange}
      />
      <FormAmenities amenity={props.amenity} />
    </div>
  );
}
