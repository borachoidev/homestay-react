import React from 'react';
import FormHostInfo from './FormHostInfo';
import FormHouseRules from './FormHouseRules';
import FormHouseIntro from './FormHouseIntro';

import Stepper from './Stepper';

export default function HostForm() {
  return (
    <div>
      <Stepper />
      <FormHostInfo />
      <FormHouseRules />
      <FormHouseIntro />
    </div>
  );
}
