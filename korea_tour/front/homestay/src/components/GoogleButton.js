import React from 'react';
import GoogleLogin from 'react-google-login';
import { request } from 'utils/axios';
const clientId =
  '779685065070-lbrojg14lasf8j3g0gcapnctskou7pct.apps.googleusercontent.com';

export default function GoogleButton({ onSocial }) {
  const onSuccess = async res => {
    const name = res.profileObj.name;
    const avatar = res.profileObj.imageUrl;
    const id = res.googleId;
    const type = 'google';
    const data = {
      name: name,
      id: id,
      type: type,
      img: avatar,
    };
    try {
      const response = await request('post', '/homestays/signin', data);
      console.log(response.data);
    } catch (e) {
      console.log(e);
    }
  };

  const onFailure = error => {
    console.log(error);
  };

  return (
    <GoogleLogin
      clientId={clientId}
      onSuccess={onSuccess}
      onFailure={onFailure}
    />
  );
}
