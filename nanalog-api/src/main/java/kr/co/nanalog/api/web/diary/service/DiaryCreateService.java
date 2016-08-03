package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.request.ComponentCreateRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageCreateRequest;

/**
 * Created by JUNG on 2016. 7. 29..
 */
public interface DiaryCreateService {

    Integer createPage(DiaryPageCreateRequest diaryPageCreateRequest);
    Integer createComponent(ComponentCreateRequest componentCreateRequest);
}
