import React, { useState } from 'react';
import { Button, TextField } from '@material-ui/core';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import DaumPostcode from 'react-daum-postcode';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';

export default function FormHostInfo(props) {
  const [state, setState] = useState({
    addr1: '',
    addr2: '',
    email1: '',
    email2: '',
    hp: '',
  });
  const postCodeStyle = {
    display: 'block',
    position: 'absolute',
    top: '50%',
    width: '400px',
    height: '500px',
    padding: '7px',
  };
  const handleChange = e => {
    setState({ ...state, [e.target.name]: e.target.value });
  };
  const handleCreataeMap = data => {
    setState({ ...state, addr1: data.address });
  };

  const showPost = () => {};
  const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };
  return (
    <div>
      <Button variant="outlined" color="primary" onClick={handleClickOpen}>
        주소검색
      </Button>
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle id="form-dialog-title">주소검색</DialogTitle>
        <DialogContent>
          <DialogContentText>
            홈스테이를 등록할 집의 주소를 입력해주세요!
          </DialogContentText>
          <DaumPostcode onComplete={handleCreataeMap} />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            확인
          </Button>
        </DialogActions>
      </Dialog>

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
    </div>
  );
}
