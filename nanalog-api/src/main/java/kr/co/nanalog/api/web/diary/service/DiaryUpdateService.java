package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.request.DiaryPageUpdateRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryUpdateRequest;

/**
 * Created by choijinjoo on 2016. 7. 30..
 */
public interface DiaryUpdateService {

    Integer updateDiary(DiaryUpdateRequest diaryUpdateRequest);

    Integer updatePage(DiaryPageUpdateRequest diaryPageUpdateRequest);

}
