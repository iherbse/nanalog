import { CALL_API} from '../api/NanalogApi'

export const NANALOG_REQUEST = 'NANALOG_REQUEST'
export const NANALOG_SUCCESS = 'NANALOG_SUCCESS'
export const NANALOG_FAILURE = 'NANALOG_FAILURE'

export const NANALOG_SIGNUP = 'NANALOG_SIGNUP'

export function signup(uid,name,password){
  return (dispatch, getState) => {

    return dispatch(fetchSignup(uid,name,password))
  }
}

// nanalog api call action
export function fetchSignup(uid,name,password){
  return{
    [CALL_API]:{
      type:[NANALOG_REQUEST,NANALOG_SUCCESS,NANALOG_FAILURE],
      method: NANALOG_SIGNUP,
      endpoint:'user/',
      uid: uid,
      name: name,
      password: password
    }
  }
}
