import React from 'react';
import AddPerson from 'components/AddPerson';
import DateFnsUtils from '@date-io/date-fns';
import Grid from '@material-ui/core/Grid';
import {
  MuiPickersUtilsProvider,
  KeyboardTimePicker,
} from '@material-ui/pickers';
import FormAmenities from './FormAmenities';

export default function FormHouseRules(props) {
  const [houseRules, setHouseRules] = props.rules;

  const handleCheckinTimeChange = date => {
    setHouseRules.checkIn(date);
  };
  const handleCheckoutTimeChange = date => {
    setHouseRules.checkOut(date);
  };
  return (
    <div>
      <MuiPickersUtilsProvider utils={DateFnsUtils}>
        <Grid container justify="space-around">
          <KeyboardTimePicker
            autoOk
            variant="inline"
            openTo="hours"
            label="체크인시간"
            value={houseRules.checkIn}
            minutesStep={15}
            onChange={handleCheckinTimeChange}
          />

          <KeyboardTimePicker
            autoOk
            variant="inline"
            openTo="hours"
            label="체크아웃시간"
            value={houseRules.checkOut}
            minutesStep={15}
            onChange={handleCheckoutTimeChange}
          />
        </Grid>
      </MuiPickersUtilsProvider>
      <AddPerson maxValue={houseRules.maxPerson} />
      <FormAmenities />
    </div>
  );
}
