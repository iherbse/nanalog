package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Page;

import java.util.ArrayList;

/**
 * Created by lcw on 7/26/16.
 */
public interface DiaryListService {

    ArrayList<Page> getDiaryList(String uid);
}
