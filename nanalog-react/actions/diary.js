import * as types from '../constants/ActionTypes';
import merge from 'lodash/merge';

// read all pages
// uid, date
// diary의 pageList들을 받아옴 (쓰일지 잘 모르겠습니다)
export function fetchPageList(url) {
    return (dispatch, getState) => {
      return fetch('localhost:8080/v1/user/?uid=test2')
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
          type: types.READ_ALL_PAGE,
          date,
          diaryPages
        }
      })
  }
}

// read month pages 랑 read weekly motn pages 필요

// read page
// uid, pageId
// page에대한 상세정보를 불러옴
export function fetchPage(pageId) {
  return (dispatch, getState) => {
    return fetch('http://localhost:8000/pagedata.json')
      .then(response => response.json())
      .then(json => {
        // 받아온 json에서 필요한 값을 추출
        let pageId = null;
        let diaryComponents= null;
        if(json.pageId){
          pageId = json.pageId;
        }
        if(json.diaryComponentGetResponseModels){
          diaryComponents = json.diaryComponentGetResponseModels;
        }
        //reducer에게 전달 될 값들을 리턴해주는 함수 dispatch
        return dispatch(getPage(pageId,diaryComponents));

      })
  };
}
//reducer에게 전달될 액션타입, 데이터 return
export function getPage(pageId,diaryComponents) {
  return {
    type: types.READ_PAGE,
    pageId,
    diaryComponents
  }
}

// startDate ~ endDate 까지의 diary의 preview list를 받아옴
export function fetchPreviewPage(startDate, endDate){
  return (dispatch, getState) => {
    return fetch('http://localhost:8000/previewPageData.json')
      .then(response => response.json())
      .then(json => {
        // 받아온 json에서 필요한 값을 추출
        let pageList = json;
        console.log(pageList);

        //reducer에게 전달 될 값들을 리턴해주는 함수 dispatch
        return dispatch(PreviewPage(pageList));

      })
  };
}
// reducer에게 전달되는 액션타입, 데이터 return
// pageCount = 총 남긴 로그 수에 들어갈 수를 계산 
export function PreviewPage(pageList) {
  return {
    type: types.READ_PREVIEW_PAGE,
    pageList : pageList,
    pageCount : pageList.length
  };
}
// pageId, userId, createdAt
export function createPage(){

}
//componentId,pageId,componentDate,componentType,componentPosition
export function createComponent(){

}
//pageId,componentId,componentPosition,componentData => list
export function updatePage(){

}

//pageId,componentId,componentPosition,componentData
export function updateComponent(){

}
//deletePageId,userId
export function deletePage(){

}
//UserId,componentId
export function deleteComponent(){

}
