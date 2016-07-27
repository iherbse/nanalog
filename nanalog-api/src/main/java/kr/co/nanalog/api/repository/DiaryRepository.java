package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    @Query("select d from Diary d where d.userId=?1")
    Diary getMyDiaryByUid(String uid);

    @Query("select b from Board b where b.diaryId=?1")
    ArrayList<Board> getMyBoardByDiaryId(Long diaryId);

    @Query("select c from Contents c where c.boardId=?1")
    ArrayList<Component> getMyDiaryByBoardId(Long boardId);

}
