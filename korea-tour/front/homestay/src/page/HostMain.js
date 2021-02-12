import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { URL } from '_utils/api';
import store from '_store/Store';

export default function HostManageHouse() {
  const num = store.getState().userReducer.num;
  const [loading, setLoading] = useState(true);
  const [hostInfo, setHostInfo] = useState({
    addr1: '',
    addr2: '',
    email1: '',
    email2: '',
    hp: '',
  });
  const [houseRules, setHouseRules] = useState({
    checkIn1: '',
    checkIn2: '',
    checkOut1: '',
    checkOut2: '',
    maxPeople: '',
    price: '',
  });
  const [amenities, setAmenities] = useState({
    dogOk: false,
    wifi: false,
    smokingOk: false,
    bathroom: false,
    parking: false,
    towel: false,
    breakfast: false,
    aircon: false,
    elecProduct: false,
    kitchen: false,
  });
  const [houseIntro, setHouseIntro] = useState({
    title: '',
    content: '',
    photo: '',
  });
  const [photos, setPhotos] = useState();

  useEffect(() => {
    const fatchData = async num => {
      setLoading(true);
      try {
        const response = await axios.get(`${URL}/house/${num}`);
        const data = response.data.dto;
        console.log(data);
        setHostInfo({
          addr1: data.addr1,
          addr2: data.addr2,
          email1: data.email1,
          email2: data.email2,
          hp: data.hp,
        });
        setHouseRules({
          checkIn1: data.checkIn1,
          checkIn2: data.checkIn2,
          checkOut1: data.checkOut1,
          checkOut2: data.checkOut2,
          maxPeople: data.maxPeople,
          price: data.price,
        });
        setAmenities({
          dogOk: data.dogOk == 1 ? true : false,
          wifi: data.wifi == 1 ? true : false,
          smokingOk: data.smokingOk == 1 ? true : false,
          bathroom: data.bathroom == 1 ? true : false,
          parking: data.parking == 1 ? true : false,
          towel: data.towel == 1 ? true : false,
          breakfast: data.breakfast == 1 ? true : false,
          aircon: data.aircon == 1 ? true : false,
          elecProduct: data.elecProduct == 1 ? true : false,
          kitchen: data.kitchen == 1 ? true : false,
        });
        setHouseIntro({
          title: data.title,
          content: data.content,
        });
        console.log(response.data.dto);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fatchData(num);
  }, []);

  //사진 가져오기
  useEffect(() => {
    const getPhoto = async num => {
      setLoading(true);
      try {
        const response = await axios.get(`${URL}/photo/${num}`);
        const data = response.data.list;
        console.log(data);
        setPhotos(data);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    getPhoto(num);
  }, []);

  if (loading) {
    return <p>대기중....</p>;
  }

  return <></>;
}
