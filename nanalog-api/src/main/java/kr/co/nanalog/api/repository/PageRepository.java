package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
public interface PageRepository extends JpaRepository<Page, Long> {

    @Query("select p " +
            "from Page p " +
            "where p.pageId = ?1 ")
    Page findByPageId(Long pageId);

    @Query("select p from Page p where p.diaryId=?1 order by p.createdDate")
    ArrayList<Page> getPageByDiaryId(String uid);

    @Query("delete from Page p" +
            "where p.pageId = ?1")
    void deleteByPageId(Long pageId);



}
