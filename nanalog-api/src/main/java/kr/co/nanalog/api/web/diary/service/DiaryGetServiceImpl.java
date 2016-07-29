package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Diary;
import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.repository.DiaryRepository;
import kr.co.nanalog.api.web.diary.model.request.DiaryListRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryViewRequest;
import kr.co.nanalog.api.web.diary.model.response.DiaryListResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryViewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by lcw on 7/26/16.
 */
@Service
@Transactional
public class DiaryGetServiceImpl implements DiaryGetService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private ComponentRepository componentRepository;


    @Override
    public DiaryListResponse getDiaryList(DiaryListRequest diaryListRequest) {
        DiaryListResponse diaryListResponse = new DiaryListResponse();

        ArrayList<Diary> myDiary = diaryRepository.getDiaryByUid(diaryListRequest.getUid());
        diaryListResponse.setDiaries(myDiary);

        ArrayList<ArrayList<Page>> myAllPages = new ArrayList<ArrayList<Page>>();
        for (int i = 0; i < myDiary.size(); i++) {
            ArrayList<Page> myPages = pageRepository.getPageByDiaryId(myDiary.get(i).getDiaryId(), diaryListRequest.getDate());

            myAllPages.add(myPages);

        }
        diaryListResponse.setPages(myAllPages);

        ArrayList<Integer> totalPagesOfDiaries = new ArrayList<>();
        Integer i = 0;
        for (Diary diary : myDiary) {
            totalPagesOfDiaries.add(pageRepository.getPageByDiaryId(myDiary.get(i).getDiaryId()).size());
            i++;
        }
        diaryListResponse.setTotalPagesOfDiaries(totalPagesOfDiaries);

        return diaryListResponse;
    }

    @Override
    public DiaryViewResponse getDiaryView(DiaryViewRequest diaryViewRequest) {
        DiaryViewResponse diaryViewResponse = new DiaryViewResponse();

        ArrayList<Component> components = componentRepository.getComponentsByPageId(diaryViewRequest.getPageId());
        diaryViewResponse.setComponents(components);

        return diaryViewResponse;
    }
}
