import * as types from '../constants/ActionTypes';

export default function diary(state = null, action) {
  switch (action.type) {
    case types.CREATE_DIARY:
      return Object.assign({}, state, {});
    case types.READ_ALL_DIARY:
      return Object.assign({}, state, {});
    case types.READ_DIARY:
      return Object.assign({}, state, {});
    default:
      return state;
  }
}
