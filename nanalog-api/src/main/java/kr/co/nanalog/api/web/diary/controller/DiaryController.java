package kr.co.nanalog.api.web.diary.controller;


import kr.co.nanalog.api.domain.ApiResponseBody;
import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.web.diary.model.request.DiaryDeleteRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryListRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryViewRequest;
import kr.co.nanalog.api.web.diary.model.response.DiaryListResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryViewResponse;
import kr.co.nanalog.api.web.diary.service.DiaryGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by lcw on 7/26/16.
 */
@RestController
@RequestMapping("/v1/diary")
public class DiaryController {
    @Autowired
    private DiaryGetService diaryGetService;

    @RequestMapping(method = RequestMethod.GET)
    public ApiResponseBody<DiaryListResponse> getDiaryList(@RequestParam(required = true) String uid, @RequestParam(required = true) Integer month) {
        DiaryListRequest diaryListRequest = new DiaryListRequest();
        diaryListRequest.setUid(uid);
        diaryListRequest.setDate(month);

        DiaryListResponse diaryListResponse = diaryGetService.getDiaryList(diaryListRequest);

        if (diaryListResponse == null) {
            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
        }
        return new ApiResponseBody<DiaryListResponse>(diaryListResponse);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ApiResponseBody<DiaryViewResponse> getDiaryView(@RequestParam(required = true) Long pageId) {
        DiaryViewRequest diaryViewRequest = new DiaryViewRequest();
        diaryViewRequest.setPageId(pageId);

        DiaryViewResponse diaryViewResponse = diaryGetService.getDiaryView(diaryViewRequest);

        if (diaryViewResponse == null) {
            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
        }
        return new ApiResponseBody<DiaryViewResponse>(diaryViewResponse);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteDiary(@Valid DiaryDeleteRequest userDeleteRequest, BindingResult bindingResult) {

        return new ResponseEntity(HttpStatus.OK);
    }


}
