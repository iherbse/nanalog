package kr.co.nanalog.api.web.diary.controller;


import kr.co.nanalog.api.domain.ApiResponseBody;
import kr.co.nanalog.api.entity.Board;
import kr.co.nanalog.api.web.diary.model.request.DiaryDeleteRequest;
import kr.co.nanalog.api.web.diary.service.DiaryListService;
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
    private DiaryListService diaryListService;

    @RequestMapping(method = RequestMethod.GET)
    public ApiResponseBody<ArrayList<Board>> getDiaryList(@RequestParam(required = true) String uid){
        ArrayList<Board> list = diaryListService.getDiaryList(uid);

        if(list.size()==0){
            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
        }
        return new ApiResponseBody<ArrayList<Board>>(list);
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public ResponseEntity deleteDiary(@Valid DiaryDeleteRequest userDeleteRequest, BindingResult bindingResult){

        return new ResponseEntity(HttpStatus.OK);
    }

}
