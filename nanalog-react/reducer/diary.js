import * as types from '../constants/ActionTypes';


export default function diary(state = null, action) {
  console.log(action);
  console.log(action.type);
  switch (action.type) {
    case types.READ_ALL_PAGE:
      return Object.assign({}, state, {
        date: action.date,
        diaryPages : action.diaryPages
      });
    case types.READ_PAGE:
      return Object.assign({}, state, {
        pageId: action.pageId,
        diaryComponents: action.diaryComponents
      });
    case types.READ_PREVIEW_PAGE:
    console.log("READ_PREVIEW_PAGE");
      return Object.assign({}, state, {
        pageList: action.pageList,
        pageCount: action.pageCount
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
