import * as types from '../constants/ActionTypes';
import merge from 'lodash/merge';


export function fetchPageList(url) {
    return (dispatch, getState) => {
      return fetch('http://localhost:8000/pageListdata.json')
      .then(
        function(response) {
          if (response.status !== 200) {
            console.log('Looks like there was a problem. Status Code: ' +
              response.status);
            return;
          }

          // Examine the text in the response
          response.json().then(function(data) {
            console.log(data);
          });
        }
      )
      .catch(function(err) {
        console.log('Fetch Error :-S', err);
      });
  }
}
export function fetchPage(url) {
  return (dispatch, getState) => {
    return fetch('http://localhost:8000/pagedata.json')
      .then(response => response.json())
      .then(json => {
        let pageId = null;
        let diaryComponents= null;
        if(json.pageId){
          pageId = json.pageId;
        }
        if(json.diaryComponentGetResponseModels){
          diaryComponents = json.diaryComponentGetResponseModels;
        }
        return {
          type: types.READ_DIARY,
          pageId,
          diaryComponents
        }
      })
  };
}
