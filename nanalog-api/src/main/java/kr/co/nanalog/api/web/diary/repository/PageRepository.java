package kr.co.nanalog.api.web.diary.repository;

import kr.co.nanalog.api.web.diary.model.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
public interface PageRepository extends JpaRepository<Page, Long> {

    @Query("select p from Page p where p.uid=?1")
    List<Page> getPagesByUid(String uid);

    @Query("select p " +
            "from Page p " +
            "where p.pageId = ?1 ")
    Page findByPageId(Long pageId);

    @Query("delete from Page p where p.pageId = ?1")
    void deleteBypageId(Long pageId);

    @Query("select p " +
            "from Page p " +
            "where p.uid = ?1 ")
    List<Page> findByUid(String uid);

    @Query("delete from Page p where p.uid = ?1")
    void deleteByUid(String uid);

    @Query("select p from Page p where p.uid = ?1 AND p.createdDate = ?2")
    Page findByUidAndDate(String uid, String date);

}
