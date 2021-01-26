import React, { useState } from 'react';
import { Button, TextField } from '@material-ui/core';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import MapContainer from './MapContainer';
import PostCodeSearch from './PostCodeSearch';

export default function FormHostInfo(props) {
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
      <MapContainer />
      <TextField
        label="주소"
        margin="normal"
        value={state.addr1}
        name="addr1"
        onChange={handleChange}
      />
      <TextField
        label="상세주소"
        margin="normal"
        value={state.addr2}
        name="addr2"
        onChange={handleChange}
      />
      <TextField
        label="email"
        margin="normal"
        value={state.email1}
        name="email1"
        onChange={handleChange}
      />
      <TextField
        label="도메인"
        margin="normal"
        value={state.email2}
        name="email2"
        onChange={handleChange}
      />
      <InputLabel id="domain">선택하세요</InputLabel>
      <Select
        labelId="domain"
        id="domain-select"
        value={state.email2}
        name="email2"
        onChange={handleChange}
      >
        <MenuItem value="gmail.com">gmail.com</MenuItem>
        <MenuItem value="naver.com">naver.com</MenuItem>
        <MenuItem value="hanmail.net">hanmail.net</MenuItem>
        <MenuItem value="nate.com">nate.com</MenuItem>
        <MenuItem>직접입력</MenuItem>
      </Select>
      <TextField
        label="연락처"
        margin="normal"
        value={state.hp}
        name="hp"
        onChange={handleChange}
      />
      <PostCodeSearch />c
    </div>
  );
}
