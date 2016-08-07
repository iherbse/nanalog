package kr.co.nanalog.api.web.diary;


import kr.co.nanalog.api.web.common.domain.ApiResponseBody;
import kr.co.nanalog.api.web.diary.model.request.*;
import kr.co.nanalog.api.web.diary.model.response.DiaryComponentGetResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryPageGetResponse;
import kr.co.nanalog.api.web.diary.service.DiaryCreateService;
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
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private DiaryCreateService diaryCreateService;

    @RequestMapping(method = RequestMethod.GET)
    public ApiResponseBody<DiaryPageGetResponse> getDiaryPages(@Valid DiaryPageGetRequest diaryPageGetRequest){

        DiaryPageGetResponse diaryPageGetResponse = diaryGetService.getDiaryPages(diaryPageGetRequest);

        if(diaryPageGetResponse == null){
            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
        }

        return new ApiResponseBody<DiaryPageGetResponse>(diaryPageGetResponse);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ApiResponseBody<DiaryComponentGetResponse> getPageComponents(@Valid DiaryComponentGetRequest diaryComponentGetRequest){

        DiaryComponentGetResponse diaryComponentGetResponse = diaryGetService.getDiaryCompoents(diaryComponentGetRequest);

        if(diaryComponentGetResponse == null){
            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
        }

        return new ApiResponseBody<DiaryComponentGetResponse>(diaryComponentGetResponse);
    }
    @RequestMapping(value = "/page", method = RequestMethod.PUT)
    public ResponseEntity createPage(@Valid DiaryPageCreateRequest diaryPageCreateRequest) {
        int resultCode = diaryCreateService.createPage(diaryPageCreateRequest);

        if(resultCode == -1) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/component", method = RequestMethod.PUT)
    public ResponseEntity createComponent(@Valid ComponentCreateRequest componentCreateRequest) {
        int resultCode = diaryCreateService.createComponent(componentCreateRequest);

        if(resultCode == -1) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "/component", method = RequestMethod.PUT)
    public ResponseEntity updateDiary(@Valid DiaryUpdateRequest updateRequest) {
        int resultCode = diaryUpdateService.updateComponent(updateRequest);

        if (resultCode == 0) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        //result Code = 1
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/page", method = RequestMethod.PUT)
    public ResponseEntity updateDiary(@Valid List<DiaryUpdateRequest> updateRequest) {
        int resultCode = diaryUpdateService.updateDiary(updateRequest);

        if (resultCode == 0) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        //result Code = 1
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deletePage(@Valid DiaryPageDeleteRequest diaryPageDeleteRequest, BindingResult bindingResult) {

        int resultCode = diaryDeleteService.deletePage(diaryPageDeleteRequest);

        if(resultCode == -1){
            return  new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/component", method = RequestMethod.DELETE)
    public ResponseEntity deleteComponent(@Valid ComponentDeleteRequest componentDeleteRequest){

        int resultCode = diaryDeleteService.deleteComponent(componentDeleteRequest);

        if(resultCode == -1){
            return  new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@Valid DiaryUserDeleteRequest diaryUserDeleteRequest){
        int resultCode = diaryDeleteService.deleteUser(diaryUserDeleteRequest);

        return new ResponseEntity(HttpStatus.OK);
    }

}
