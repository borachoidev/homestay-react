import { combineReducers } from 'redux';
import userReducer from '_reducers/userReducer';
import search from '_reducers/searchReducer';

const rootReducer = combineReducers({
  userReducer,
  search,
});

export default rootReducer;
