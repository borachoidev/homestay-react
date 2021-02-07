import axios from 'axios';
import {
  SEARCH,
  CHANGE_LOCATION,
  CHANGE_CHECKIN,
  CHANGE_CHECKOUT,
  CHANGE_COUNT,
} from './types';
export function changeLocation() {
  return {
    type: CHANGE_LOCATION,
  };
}

export function search() {
  let url = `http://localhost:9003/homestays/signin/`;
  return function (dispatch) {
    axios
      .post(url, APIdata)
      .then(response => {
        const userData = response.data;
        return dispatch({
          type: SEARCH,
          APIdata,
          userData,
        });
      })
      .catch(response =>
        dispatch({
          type: SEARCH,
          error: response.error,
        })
      );
  };
}
