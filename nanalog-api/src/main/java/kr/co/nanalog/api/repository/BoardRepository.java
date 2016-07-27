package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.Board;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
public interface BoardRepository {

    @Query("select b from Board b where b.diaryId=?1")
    ArrayList<Board> getMyBoardByDiaryId(Long diaryId);

    @Query("delete from Board b" +
            "where b.boardId = ?1")
    void deleteByBoardId(Long boardId);
}
