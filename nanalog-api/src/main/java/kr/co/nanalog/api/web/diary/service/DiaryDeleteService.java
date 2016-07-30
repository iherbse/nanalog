package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.request.ComponentDeleteRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageDeleteRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryUserDeleteRequest;

/**
 * Created by Leegain on 2016-07-27.
 */

public interface DiaryDeleteService {
    Integer deletePage(DiaryPageDeleteRequest diaryPageDeleteRequest);
    Integer deleteComponent(ComponentDeleteRequest componentDeleteRequest);
    Integer deleteUser(DiaryUserDeleteRequest diaryUserDeleteRequest);
}
