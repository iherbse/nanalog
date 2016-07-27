package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.repository.DiaryRepository;
import kr.co.nanalog.api.web.diary.model.request.DiaryDeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Leegain on 2016-07-27.
 */
public class DiaryDeleteServiceImpl implements DiaryDeleteService {
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    //private ContentsRepository contentsRepository;


    public Integer deleteDiary(DiaryDeleteRequest diaryDeleteRequest){

        Long deletboardid = diaryDeleteRequest.getDeleteBoardId();

        componentRepository.deleteCreatedComponentByBoardId(deletboardid);

      //  contentsRepository.deleteContentsByBoardId(deletboardid);

        pageRepository.deleteByBoardId(deletboardid);


        return null;
    }

}
