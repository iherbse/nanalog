import { routerReducer as routing } from 'react-router-redux'
import { combineReducers } from 'redux'
import diary from './diary'


const rootReducer = combineReducers({
  diary : diary,
  routing : routing
});

export default rootReducer;
