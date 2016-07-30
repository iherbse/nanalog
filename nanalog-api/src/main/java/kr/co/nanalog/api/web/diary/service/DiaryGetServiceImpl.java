package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.web.diary.model.request.DiaryComponentGetRequest;
import kr.co.nanalog.api.web.diary.model.response.DiaryComponentGetResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryPageGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lcw on 7/26/16.
 */
@Service
@Transactional
public class DiaryGetServiceImpl implements DiaryGetService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Override
    public DiaryPageGetResponse getDiaryPages(DiaryComponentGetRequest diaryComponentGetRequest) {
        return null;
    }

    @Override
    public DiaryComponentGetResponse getDiaryCompoents(DiaryComponentGetRequest diaryComponentGetRequest) {
        return null;
    }
}
