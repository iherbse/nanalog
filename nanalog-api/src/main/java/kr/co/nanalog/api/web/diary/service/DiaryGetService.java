package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.web.diary.model.request.DiaryListRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryViewRequest;
import kr.co.nanalog.api.web.diary.model.response.DiaryListResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryViewResponse;

import java.util.ArrayList;

/**
 * Created by lcw on 7/26/16.
 */
public interface DiaryGetService {

    DiaryListResponse getDiaryList(DiaryListRequest diaryListRequest);

    DiaryViewResponse getDiaryView(DiaryViewRequest diaryViewRequest);
}
