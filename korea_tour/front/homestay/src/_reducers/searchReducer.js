import {
  SEARCH,
  CHANGE_LOCATION,
  CHANGE_CHECKIN,
  CHANGE_CHECKOUT,
  CHANGE_COUNT,
} from '_actions/types';

const initialState = {
  input: '',
  location: '',
  checkin: '',
  checkout: '',
  count: 0,
};

export default function search(state = initialState, action) {
  switch (action.type) {
    case SEARCH:
      return {
        ...state,
        input: action.input,
      };
    default:
      return state;
  }
}
