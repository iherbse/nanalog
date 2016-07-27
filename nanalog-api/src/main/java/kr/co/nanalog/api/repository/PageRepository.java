package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
public interface PageRepository {

    @Query("select p from Page p where p.diaryId=?1")
    ArrayList<Page> getMyBoardByDiaryId(Long diaryId);

    @Query("delete from Page p" +
            "where p.boardId = ?1")
    void deleteByBoardId(Long boardId);
}
