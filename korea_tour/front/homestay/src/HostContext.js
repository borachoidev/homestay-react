import React, { useState, useContext } from 'react';
import HostForm from 'components/HostForm';
const HostContext = React.createContext();

const HostProvider = () => {
  const [step, setStep] = useState(0);
  const [hostInfo, setHostInfo] = useState({
    addr1: '',
    addr2: '',
    email1: '',
    email2: '',
    hp: '',
  });
  const [houseRules, setHouseRules] = useState({
    checkIn: new Date(),
    checkOut: new Date(),
    maxPerson: 0,
  });
  const [amenities, setAmenities] = useState({
    petAllow: false,
    wifiService: false,
    smoking: false,
    restroom: false,
    parking: false,
    bathAmenity: false,
    breakfast: false,
    ac: false,
    elect: false,
    useKitchen: false,
  });
  const [houseIntro, setHouseIntro] = useState({
    title: '',
    description: '',
    photo: '',
  });

  return (
    <div>
      <HostContext.Provider
        value={{
          step,
          setStep,
          hostInfo,
          setHostInfo,
          houseRules,
          setHouseRules,
          amenities,
          setAmenities,
          houseIntro,
          setHouseIntro,
        }}
      >
        <HostForm />
      </HostContext.Provider>
    </div>
  );
};
export { HostProvider, HostContext };
