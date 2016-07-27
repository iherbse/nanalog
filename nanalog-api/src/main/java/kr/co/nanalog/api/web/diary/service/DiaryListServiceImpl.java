package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.entity.Diary;
import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by lcw on 7/26/16.
 */
@Service
@Transactional
public class DiaryListServiceImpl implements  DiaryListService{

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public ArrayList<Page> getDiaryList(String uid) {

        Diary diary =  diaryRepository.getMyDiaryByUid(uid);
        ArrayList<Page> list = pageRepository.getMyBoardByDiaryId(diary.getDiaryId());

        return list;
    }
}
