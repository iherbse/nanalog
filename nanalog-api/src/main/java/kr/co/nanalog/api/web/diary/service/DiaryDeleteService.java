package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.request.ComponentDeleteRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryDeleteRequest;

/**
 * Created by Leegain on 2016-07-27.
 */

public interface DiaryDeleteService {
    Integer deleteDiary(DiaryDeleteRequest diaryDeleteRequest);
    Integer deleteComponent(ComponentDeleteRequest componentDeleteRequest);
}
