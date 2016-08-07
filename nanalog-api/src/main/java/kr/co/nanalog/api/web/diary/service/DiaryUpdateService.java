package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.request.DiaryUpdateRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by choijinjoo on 2016. 7. 30..
 */
public interface DiaryUpdateService {

    Integer updateDiary(List<DiaryUpdateRequest> diaryUpdateRequest);
    Integer updateComponent(DiaryUpdateRequest diaryUpdateRequest);

}
