import { Schema, arrayOf, normalize } from 'normalizr'
import { camelizeKeys } from 'humps'
import 'isomorphic-fetch'
import NANALOG_SIGNUP from '../actions/actions'

// nanalog url
const API_ROOT = 'http://localhost:8080/v1/'

// Fetches an API response and normalizes the result JSON according to schema.
// This makes every API response have the same shape, regardless of how nested it was.

// call nanalog signup api
function callApiSignup(endpoint,uid,name,password) {

  const fullUrl = (endpoint.indexOf(API_ROOT) === -1) ? API_ROOT + endpoint : endpoint

  return fetch(fullUrl,{
    method: 'POST',
    body: JSON.stringify({
        uid : uid,
        name : name,
        password : password
      })
    }).then(response =>
      response.json().then(json => ({ json, response }))
    ).then(({ json, response }) => {

      if (!response.ok) {
        return Promise.reject(json)
      }

      const camelizedJson = camelizeKeys(json)
      console.log(json);
      return Object.assign({},
        camelizedJson
      )
    })
}


// Action key that carries API call info interpreted by this Redux middleware.
export const CALL_API = Symbol('Call API')

// A Redux middleware that interprets actions with CALL_API info specified.
// Performs the call and promises when such actions are dispatched.

export default store => next => action => {

  const callAPI = action[CALL_API]

// action이 api call이 아닌경우에는 그냥 pass (next = dispatch)
  if (typeof callAPI === 'undefined') {
    return next(action)
  }

  let { method } = callAPI
  const { type } = callAPI

  if(method === NANALOG_SIGNUP){
    const [ requestType, successType, failureType ] = type
    const { endpoint, uid, name, password } = callAPI
    return callApiSignup(endpoint, uid,name,password).then(
      response => next(actionWith({
        response,
        type: successType
      })),
      error => next(actionWith({
        type: failureType,
        error: error.message || 'Something bad happened'
      }))
    )
  }


  function actionWith(data) {
    const finalAction = Object.assign({}, action, data)

    delete finalAction[CALL_API]
    return finalAction
  }

  const [ requestType, successType, failureType ] = type

  return next(action)
}
