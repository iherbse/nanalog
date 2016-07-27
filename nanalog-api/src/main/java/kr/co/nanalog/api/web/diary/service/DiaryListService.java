package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Board;
import kr.co.nanalog.api.web.diary.model.request.DiaryListRequest;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
public interface DiaryListService {

    ArrayList<Board> getDiaryList(String uid);
}
