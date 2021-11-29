import React from 'react';
import { Button, TextField, Typography } from '@material-ui/core';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import { makeStyles } from '@material-ui/core/styles';
import DaumPostcode from 'react-daum-postcode';
import {
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
} from '@material-ui/core';

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
    display: 'flex',
    width: '65%',
    flexDirection: 'column',
    margin: 'auto',
  },
  inline: {
    display: 'flex',
    alignItems: 'center',
  },
  select: {
    display: 'flex',
    width: '95%',
    flexDirection: 'column',
    justifyContent: 'flex-end',
    margin: 'auto',
  },
}));
export default function FormHostInfo(props) {
  const classes = useStyles();
  const [hostInfo, setHostInfo] = props.info;

  const handleChange = e => {
    if (e.target.name == 'hp') {
      console.log(e.target.value);
      if (e.target.value.length > 11) {
        e.target.value = e.target.value.substr(0, 11);
      }
    }
    setHostInfo({ ...hostInfo, [e.target.name]: e.target.value });
  };
  const handleCreataeMap = data => {
    setHostInfo({ ...hostInfo, addr1: data.address });
  };

  const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div className={classes.root}>
      <Button variant="outlined" color="primary" onClick={handleClickOpen}>
        주소검색
      </Button>
      {/* 주소검색모달 */}
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
      {/* 폼입력 */}
      <TextField
        label="주소"
        margin="normal"
        value={hostInfo.addr1}
        name="addr1"
        onChange={handleChange}
      />
      <TextField
        label="상세주소"
        margin="normal"
        value={hostInfo.addr2}
        name="addr2"
        onChange={handleChange}
      />

      <TextField
        label="email"
        margin="normal"
        value={hostInfo.email1}
        name="email1"
        onChange={handleChange}
      />
      <div className={classes.inline}>
        <Typography display="inline">@</Typography>
        <div className={classes.select}>
          <InputLabel id="domain" display="inline">
            선택하세요
          </InputLabel>
          <Select
            labelId="domain"
            id="domain-select"
            value={hostInfo.email2}
            name="email2"
            onChange={handleChange}
          >
            <MenuItem value="gmail.com">gmail.com</MenuItem>
            <MenuItem value="naver.com">naver.com</MenuItem>
            <MenuItem value="hanmail.net">hanmail.net</MenuItem>
            <MenuItem value="nate.com">nate.com</MenuItem>
            <MenuItem>직접입력</MenuItem>
          </Select>
        </div>
      </div>
      <TextField
        label="도메인"
        margin="normal"
        value={hostInfo.email2}
        name="email2"
        onChange={handleChange}
      />
      <TextField
        label="연락처"
        type="number"
        margin="normal"
        inputProps={{ placeholder: '숫자만입력해주세요' }}
        value={hostInfo.hp}
        name="hp"
        onChange={handleChange}
      />
    </div>
  );
}
