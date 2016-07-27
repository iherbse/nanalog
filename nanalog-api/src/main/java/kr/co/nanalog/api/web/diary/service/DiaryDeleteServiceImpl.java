package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.repository.BoardRepository;
import kr.co.nanalog.api.repository.ContentsRepository;
import kr.co.nanalog.api.repository.CreatedComponentRepository;
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
    private BoardRepository boardRepository;
    @Autowired
    private CreatedComponentRepository createdComponentRepository;
    @Autowired
    private ContentsRepository contentsRepository;


    public Integer deleteDiary(DiaryDeleteRequest diaryDeleteRequest){

        Long deletboardid = diaryDeleteRequest.getDeleteBoardId();

        createdComponentRepository.deleteCreatedComponentByBoardId(deletboardid);

        contentsRepository.deleteContentsByBoardId(deletboardid);

        boardRepository.deleteByBoardId(deletboardid);


        return null;
    }

}
