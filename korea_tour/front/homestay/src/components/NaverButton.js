import React from 'react';
import NaverLogin from 'react-naver-login';
import { connect } from 'react-redux';
import { signIn } from '_actions/user';
let data;
function NaverButton({ signIn }) {
  const btnStyle = {
    width: 174,
    height: 44,
    color: '#fafefc',
    backgroundColor: '#5CC75B',
    border: '1px solid transparent',
    fontSize: '1rem',
    cursor: 'pointer',
  };
  const sendApi = async res => {
    const id = res.id;
    const name = res.name;
    const avatar = res.profile_image;
    const type = 'NAVER';
    return (data = {
      name: name,
      id: id,
      type: type,
      img: avatar,
    });
  };
  return (
    <button style={btnStyle}>
      <NaverLogin
        clientId="XsYIxoQxXx7dgXFoawSE"
        callbackUrl="http://www.raonhomestay.tk"
        render={props => <div onClick={props.onClick}>Naver Login</div>}
        onSuccess={res => sendApi(res).then(signIn)}
        onFailure={() => console.error()}
      />
    </button>
  );
}
export default connect(null, dispatch => ({
  signIn: () => dispatch(signIn(data)),
}))(NaverButton);
