import { composeWithDevTools } from 'redux-devtools-extension';
import rootReducer from '_reducers';
import { applyMiddleware, createStore } from 'redux';
import promiseMiddlerware from 'redux-promise';
import reduxThunk from 'redux-thunk';

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(promiseMiddlerware, reduxThunk))
);

export default store;
