import React, { useState, useEffect } from 'react';
import axios from 'axios';
import store from '_store/Store';

function ModifySubmit(props) {
  const num = store.getState().userReducer.num;
  const hostInfo = props.info;
  const houseIntro = props.intro;
  const amenities = props.amenity;
  const houseRules = props.rules;
  const photonum = 0;
  const [contents, setContents] = useState(null);
  const [loading, setLoading] = useState(false);
  const data = {
    userNum: num,
    addr1: hostInfo.addr1,
    addr2: hostInfo.addr2,
    email1: hostInfo.email1,
    email2: hostInfo.email2,
    hp: hostInfo.hp,
    checkIn1: houseRules.checkIn1,
    checkIn2: houseRules.checkIn2,
    checkOut1: houseRules.checkOut1,
    checkOut2: houseRules.checkIn2,
    maxPeople: houseRules.maxPeople,
    price: houseRules.price,
    dogOk: amenities.dogOk ? 1 : 0,
    wifi: amenities.wifi ? 1 : 0,
    smokingOk: amenities.smokingOk ? 1 : 0,
    bathroom: amenities.bathroom ? 1 : 0,
    parking: amenities.parkin ? 1 : 0,
    towel: amenities.towel ? 1 : 0,
    breakfast: amenities.breackfast ? 1 : 0,
    aircon: amenities.aricon ? 1 : 0,
    elecProduct: amenities.elecProduct ? 1 : 0,
    kitchen: amenities.kitchen ? 1 : 0,
    title: houseIntro.title,
    content: houseIntro.content,
    photo: houseIntro.photo,
  };
  const imageFile = props.image;
  useEffect(() => {
    // async를 사용하는 함수 따로 선언
    const sendData = async num => {
      setLoading(true);
      try {
        const response = await axios
          .post(`http://localhost:9003/homestays/house/${num}`, data)
          .then(() => {
            alert('완료!');
          });
        console.log(data);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    sendData(num);
  }, []);

  // 사진업로드
  useEffect(num => {
    let url = `http://localhost:9003/homestays/photo/${num}`;

    // async를 사용하는 함수 따로 선언
    const sendPhoto = async () => {
      setLoading(true);
      try {
        const response = await axios.post(url, imageFile).then(() => {
          alert('완료!');
        });
        console.log(data);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    sendPhoto(num);
  }, []);

  //사진삭제
  useEffect(photonum => {
    let url = `http://localhost:9003/homestays/photo/${photonum}`;

    const deletePhoto = async () => {
      setLoading(true);
      try {
        const response = await axios.delete(url, imageFile).then(() => {
          alert('완료!');
        });
        console.log(data);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    deletePhoto(photonum);
  }, []);

  if (loading) {
    return <p>대기중....</p>;
  }

  return <div></div>;
}

export default ModifySubmit;
