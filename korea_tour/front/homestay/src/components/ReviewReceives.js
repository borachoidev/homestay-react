import React from 'react';
import { SampleConsumer } from './ReviewContext';

const Receives = () => {
  return (
    <SampleConsumer>
        {
        ({state}) => (   
     <div>
      현재 설정된 값: {state.value}
     </div>
        )
        }
    </SampleConsumer>
 
  );
};

export default Receives;
npm i react-context-form