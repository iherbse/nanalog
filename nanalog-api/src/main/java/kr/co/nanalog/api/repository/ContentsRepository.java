package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Diary;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
public interface ContentsRepository {

    @Query("select c from Contents c where c.boardId=?1")
    ArrayList<Component> getMyDiaryByBoardId(Long boardId);
}
