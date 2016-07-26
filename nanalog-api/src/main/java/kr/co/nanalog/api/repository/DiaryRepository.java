package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.Diary;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by choijinjoo on 2016. 7. 26..
 */
public interface DiaryRepository {

    @Query("select * " +
            "from Diary d " +
            "where d.did = ?1 ")
    Diary findByDid(String did);



}
