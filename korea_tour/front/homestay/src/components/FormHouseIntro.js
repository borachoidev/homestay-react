import React, { useState } from 'react';
import { Button, TextField } from '@material-ui/core';
import IconButton from '@material-ui/core/IconButton';
import PhotoCamera from '@material-ui/icons/PhotoCamera';

export default function FormHouseIntro(props) {
  const [state, setState] = useState({
    addr1: '',
    addr2: '',
    email1: '',
    email2: '',
    hp: '',
  });
  const handleChange = e => {
    setState({ ...state, [e.target.name]: e.target.value });
  };
  return (
    <div>
      <TextField label="집 이름" margin="normal" />
      <TextField label="설명 해주세요!" margin="normal" />
      <input accept="image/*" id="icon-button-file" type="file" multiple />
      <label htmlFor="icon-button-file">
        <IconButton
          color="primary"
          aria-label="upload picture"
          component="span"
        >
          <PhotoCamera />
        </IconButton>
      </label>
    </div>
  );
}
