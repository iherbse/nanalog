package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.request.DiaryUpdateRequest;

import java.util.ArrayList;

/**
 * Created by choijinjoo on 2016. 7. 30..
 */
public interface DiaryUpdateService {

    Integer updateDiary(ArrayList<DiaryUpdateRequest> diaryUpdateRequest);
    Integer updateComponent(DiaryUpdateRequest diaryUpdateRequest);

}
