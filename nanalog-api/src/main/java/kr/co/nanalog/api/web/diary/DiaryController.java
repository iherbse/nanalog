package kr.co.nanalog.api.web.diary;


import kr.co.nanalog.api.web.common.domain.ApiResponseBody;
import kr.co.nanalog.api.web.diary.model.request.*;
import kr.co.nanalog.api.web.diary.model.response.DiaryComponentGetResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryPageGetResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryPreviewResponse;
import kr.co.nanalog.api.web.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcw on 7/26/16.
 */
@RestController
@RequestMapping("/v1/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public DiaryController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }



    public static final String imageRoot = "/image";

    @RequestMapping(method = RequestMethod.GET)
    public ApiResponseBody<DiaryPageGetResponse> getDiaryPages(@Valid DiaryPageGetRequest diaryPageGetRequest){

        DiaryPageGetResponse diaryPageGetResponse = diaryService.getDiaryPages(diaryPageGetRequest);

        if(diaryPageGetResponse == null){
            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
        }

        return new ApiResponseBody<DiaryPageGetResponse>(diaryPageGetResponse);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ApiResponseBody<DiaryComponentGetResponse> getPageComponents(@Valid DiaryComponentGetRequest diaryComponentGetRequest){

        DiaryComponentGetResponse diaryComponentGetResponse = diaryService.getDiaryCompoents(diaryComponentGetRequest);

        if(diaryComponentGetResponse == null){
            return new ApiResponseBody<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());
        }

        return new ApiResponseBody<DiaryComponentGetResponse>(diaryComponentGetResponse);
    }
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResponseEntity createPage(@Valid DiaryPageCreateRequest diaryPageCreateRequest) {
        int resultCode = diaryService.createPage(diaryPageCreateRequest);

        if(resultCode == -1) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/component", method = RequestMethod.POST)
    public ResponseEntity createComponent(@Valid ComponentCreateRequest componentCreateRequest) {
        int resultCode = diaryService.createComponent(componentCreateRequest);

        if(resultCode == -1) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createDiary(@Valid DiaryCreateRequest diaryCreateRequest) {
        int resultCode = diaryService.createDiary(diaryCreateRequest);

        if(resultCode == -1) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/component", method = RequestMethod.PUT)
    public ResponseEntity updateDiary(@Valid DiaryUpdateRequest updateRequest) {
        int resultCode = diaryService.updateComponent(updateRequest);

        if (resultCode == 0) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        //result Code = 1
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/page", method = RequestMethod.PUT)
    public ResponseEntity updateDiary(@Valid List<DiaryUpdateRequest> updateRequest) {
        int resultCode = diaryService.updateDiary(updateRequest);

        if (resultCode == 0) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        //result Code = 1
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deletePage(@Valid DiaryPageDeleteRequest diaryPageDeleteRequest, BindingResult bindingResult) {

        int resultCode = diaryService.deletePage(diaryPageDeleteRequest);

        if(resultCode == -1){
            return  new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/component", method = RequestMethod.DELETE)
    public ResponseEntity deleteComponent(@Valid ComponentDeleteRequest componentDeleteRequest){

        int resultCode = diaryService.deleteComponent(componentDeleteRequest);

        if(resultCode == -1){
            return  new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@Valid DiaryUserDeleteRequest diaryUserDeleteRequest){
        int resultCode = diaryService.deleteUser(diaryUserDeleteRequest);

        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "/preview", method = RequestMethod.GET)
    public List<DiaryPreviewResponse> getDiaryPreviewList(@Valid DiaryPreviewRequest diaryPreviewRequest, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ArrayList<>();
        }
        List<DiaryPreviewResponse> responseList = diaryService.getDiaryPreviewList(diaryPreviewRequest);

        return responseList;
    }

    @RequestMapping(value = "/image" ,method = RequestMethod.POST)
    public ResponseEntity setDiaryImage(@RequestParam("file")MultipartFile file, Long pageid){
        String fileName = file.getOriginalFilename();
        String filePath = Paths.get(imageRoot, fileName).toString();
        System.out.println();
        if(!file.isEmpty()){
            try{
                Files.copy(file.getInputStream(), Paths.get(imageRoot, file.getOriginalFilename()));
                System.out.println(Paths.get(imageRoot, file.getOriginalFilename()));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else {
            new ResponseEntity("에러 메시지", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

}
