import React, { useState } from 'react';
import { Button, TextField } from '@material-ui/core';
import IconButton from '@material-ui/core/IconButton';
import PhotoCamera from '@material-ui/icons/PhotoCamera';
import { HostContext } from 'HostContext';
export default function FormHouseIntro(props) {
  const [houseIntro, setHouseIntro] = props.intro;

  return (
    <div>
      <TextField label="집 이름" margin="normal" />
      <TextField label="설명 해주세요!" margin="normal" />
      <input
        accept="image/*"
        id="icon-button-file"
        type="file"
        style={{ display: 'none' }}
        multiple
      />
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
