import { routerReducer as routing } from 'react-router-redux'
import { combineReducers } from 'redux'
import diary from './diary'


const rootReducer = combineReducers({
  routing,
  diary
})

export default rootReducer;
