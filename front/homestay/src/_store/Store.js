import { composeWithDevTools } from 'redux-devtools-extension';
import rootReducer from '_reducers';
import { applyMiddleware, createStore } from 'redux';
import { persistReducer } from 'redux-persist';
import promiseMiddlerware from 'redux-promise';
import reduxThunk from 'redux-thunk';
import sessionStorage from 'redux-persist/lib/storage/session';
import hardSet from 'redux-persist/lib/stateReconciler/hardSet';

const persistConfig = {
  key: 'root',
  storage: sessionStorage,
  stateReconciler: hardSet,
};

const enhancedReducer = persistReducer(persistConfig, rootReducer);

export default createStore(
  enhancedReducer,
  composeWithDevTools(applyMiddleware(promiseMiddlerware, reduxThunk))
);
