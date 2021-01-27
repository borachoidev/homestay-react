import React, { createContext, useState } from 'react';
import HostForm from './components/HostForm';

export const multiStepHostFormContext = createContext();
// const HostFormContext = () => {
//   const [hostData, setHostData] = useState([]);
//   const [currentStep, setStep] = useState(0);
//   const [finalData, setFianlData] = useState([]);
//   return (
//     <multiStepHostFormContext.Provider
//       value={{
//         currentStep,
//         setStep,
//         hostData,
//         setHostData,
//         finalData,
//         setFianlData,
//       }}
//     >
//       <HostForm />
//     </multiStepHostFormContext.Provider>
//   );
// };

export default HostFormContext;
// const FormHostInfo = () => {
//   const hostInfo = {
//     addr: '',
//     addrDetail: '',
//     email: '',
//     emailDomain: '',
//     hp: '',
//   };
//   return (
//     <HostFormContext.Provider value={hostInfo}>
//       <div>
//         <FormHouseRules />
//       </div>
//     </HostFormContext.Provider>
//   );
// };

// const FormHouseRules = () => {
//   const hoseRules = {
//     checkinHour: '',
//     checkinMin: '',
//     checkoutHour: '',
//     checkoutMin: '',
//     maxPerson: '',
//     petAllow: '',
//     wifiService: '',
//     smoking: '',
//     restroom: '',
//     parking: '',
//     bathAmenity: '',
//     breakfast: '',
//     ac: '',
//     elect: '',
//     useKitchen: '',
//   };
//   return (
//     <HostFormContext vlaue={hoseRules}>
//       <div>
//         <FormHouseIntro />
//       </div>
//     </HostFormContext>
//   );
// };

// const FormHouseIntro = () => {
//   const houseIntro = {
//     title: '',
//     description: '',
//     photo: '',
//   };
// };
