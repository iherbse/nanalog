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
        }
      ).then(response => response.json())
      .then(json => {
        let diaryPages = null;
        let date = null;
        if(json.diaryPageGetResponseModels){
          diaryPages = json.diaryPageGetResponseModels;
        }
        if(json.date){
          date = json.date;
        }
        return {
          type: types.READ_ALL_DIARY,
          date,
          diaryPages
        }
      })
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
