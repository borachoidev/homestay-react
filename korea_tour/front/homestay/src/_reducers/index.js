import { combineReducers } from 'redux';
import userReducer from '_reducers/userReducer';
import search from 'modules/search';

const rootReducer = combineReducers({
  userReducer,
  search,
});

export default rootReducer;
