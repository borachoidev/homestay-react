import React, { useContext } from 'react';
import FormHostInfo from './FormHostInfo';
import FormHouseRules from './FormHouseRules';
import FormHouseIntro from './FormHouseIntro';
import { makeStyles } from '@material-ui/core/styles';
import { Stepper, Step, StepLabel } from '@material-ui/core';
// import { multiStepHostFormContext } from './HostFormContext';
import Button from '@material-ui/core/Button';

const useStyles = makeStyles(theme => ({
  root: {
    width: '100%',
  },
  backButton: {
    marginRight: theme.spacing(1),
  },
  instructions: {
    marginTop: theme.spacing(1),
    marginBottom: theme.spacing(1),
  },
}));
function getSteps() {
  return ['호스트정보', '숙소정보', '홈스테이소개', '입력내용확인', '신청완료'];
}
function showStep(step) {
  switch (step) {
    case 0:
      return <FormHostInfo />;
    case 1:
      return <FormHouseRules />;
    case 2:
      return <FormHouseIntro />;
    case 3:
      return <FormHouseIntro />;
    case 4:
      return <FormHouseIntro />;
  }
}
// const { currentStep, finalData } = useContext(multiStepHostFormContext);
export default function HostForm() {
  const classes = useStyles();
  const [activeStep, setActiveStep] = React.useState(0);
  const steps = getSteps();

  const handleNext = () => {
    setActiveStep(activeStep => activeStep + 1);
  };

  const handleBack = () => {
    setActiveStep(activeStep => activeStep - 1);
  };

  const handleReset = () => {
    setActiveStep(0);
  };
  return (
    <div>
      <div className={classes.root}>
        <Stepper activeStep={activeStep} alternativeLabel>
          {steps.map(label => (
            <Step key={label}>
              <StepLabel>{label}</StepLabel>
            </Step>
          ))}
        </Stepper>
        <div>{showStep(activeStep)}</div>
        <div>
          {activeStep === steps.length ? (
            <div>
              <Button onClick={handleReset}>Reset</Button>
            </div>
          ) : (
            <div>
              <div>
                <Button
                  disabled={activeStep === 0}
                  onClick={handleBack}
                  className={classes.backButton}
                >
                  Back
                </Button>
                <Button
                  variant="contained"
                  color="primary"
                  onClick={handleNext}
                >
                  {activeStep === steps.length - 1 ? 'Finish' : 'Next'}
                </Button>
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
