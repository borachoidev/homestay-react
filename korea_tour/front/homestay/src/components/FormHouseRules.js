import React, { useState } from 'react';
import AddPerson from './AddPerson';
import DateFnsUtils from '@date-io/date-fns';
import Grid from '@material-ui/core/Grid';
import {
  MuiPickersUtilsProvider,
  KeyboardTimePicker,
  KeyboardDatePicker,
} from '@material-ui/pickers';
import { TimePicker } from '@material-ui/pickers';
import FormAmenities from './FormAmenities';
export default function FormHouseRules() {
  const [checkinTime, setCheckinTime] = useState(new Date());
  const [checkoutTime, setCheckoutTime] = useState(new Date());
  const [maxValue, setMaxValue] = useState(5);
  const handleCheckinTimeChange = date => {
    setCheckinTime(date);
    console.log(checkinTime);
  };
  const handleCheckoutTimeChange = date => {
    setCheckoutTime(date);
    console.log(checkoutTime);
  };
  return (
    <div>
      <MuiPickersUtilsProvider utils={DateFnsUtils}>
        <Grid container justify="space-around">
          <TimePicker
            autoOk
            variant="static"
            openTo="hours"
            label="체크인시간"
            value={checkinTime}
            minutesStep={15}
            onChange={handleCheckinTimeChange}
          />
          <TimePicker
            autoOk
            variant="static"
            openTo="hours"
            label="체크아웃시간"
            value={checkoutTime}
            minutesStep={15}
            onChange={handleCheckoutTimeChange}
          />
        </Grid>
      </MuiPickersUtilsProvider>
      <AddPerson maxValue={maxValue} />
      <FormAmenities />
    </div>
  );
}
