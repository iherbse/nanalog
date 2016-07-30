package kr.co.nanalog.api.web.diary.controller;


import kr.co.nanalog.api.web.diary.model.request.*;
import kr.co.nanalog.api.web.diary.service.DiaryDeleteService;
import kr.co.nanalog.api.web.diary.service.DiaryGetService;
import kr.co.nanalog.api.web.diary.service.DiaryUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by lcw on 7/26/16.
 */
@RestController
@RequestMapping("/v1/diary")
public class DiaryController {
    @Autowired
    private DiaryGetService diaryGetService;

    @Autowired
    private DiaryUpdateService diaryUpdateService;

    @Autowired
    private DiaryDeleteService diaryDeleteService;


//    @RequestMapping(method = RequestMethod.GET)
//    public ApiResponseBody<DiaryGetResponse> getDiaryList(@RequestParam(required = true) String uid, @RequestParam(required = true) Integer month) {
//        DiaryGetRequest diaryListRequest = new DiaryGetRequest();
//        diaryListRequest.setUid(uid);
//        diaryListRequest.setDate(month);
//
//        DiaryGetResponse diaryListResponse = diaryGetService.getDiaryList(diaryListRequest);
//
//        if (diaryListResponse == null) {
//            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
//        }
//        return new ApiResponseBody<DiaryGetResponse>(diaryListResponse);
//    }
//
//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public ApiResponseBody<DiaryComponentGetResponse> getDiaryView(@RequestParam(required = true) Long pageId) {
//        DiaryComponentGetRequest diaryViewRequest = new DiaryComponentGetRequest();
//        diaryViewRequest.setPageId(pageId);
//
//        DiaryComponentGetResponse diaryViewResponse = diaryGetService.getDiaryView(diaryViewRequest);
//
//        if (diaryViewResponse == null) {
//            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
//        }
//        return new ApiResponseBody<DiaryComponentGetResponse>(diaryViewResponse);
//    }



    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResponseEntity updatePage(@Valid DiaryPageUpdateRequest updateRequest) {
        int resultCode = diaryUpdateService.updatePage(updateRequest);

        if (resultCode == 0) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        //result Code = 1
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteDiary(@Valid DiaryDeleteRequest diaryDeleteRequest, BindingResult bindingResult) {

        int resultCode = diaryDeleteService.deleteDiary(diaryDeleteRequest);

        if(resultCode == -1){
            return  new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/component", method = RequestMethod.DELETE)
    public ResponseEntity deletecomponent1(@Valid ComponentDeleteRequest componentDeleteRequest){

        int resultCode = diaryDeleteService.deleteComponent(componentDeleteRequest);

        if(resultCode == -1){
            return  new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

}
