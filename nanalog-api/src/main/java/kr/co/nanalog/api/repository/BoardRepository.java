package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.Board;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
public interface BoardRepository {
    @Query("select * " +
            "from Board b " +
            "where b.boardId = ?1 ")
    Board findByBoardId(String bid);
}
