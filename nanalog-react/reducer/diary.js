import * as types from '../constants/ActionTypes';

export default function diary(state = null, action) {
  switch (action.type) {
    case types.READ_ALL_PAGE:
      return Object.assign({}, state, {
        date: action.date,
        diaryPages : actions.diaryPages
      });
    case types.READ_PAGE:
      return Object.assign({}, state, {
        pageId: actions.pageId,
        diaryComponents: actions.diaryComponents
      });
    case types.CREATE_PAGE:
    case types.CREATE_COMPONENT:
    case types.DELETE_PAGE:
    case types.DELETE_COMPONENT:
    case types.UPDATE_PAGE:
    case types.UPDATE_COMPONENT:
    default:
      return state;
  }
}
