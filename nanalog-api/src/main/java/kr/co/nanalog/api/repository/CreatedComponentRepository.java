package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.Diary;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
public interface CreatedComponentRepository {

    @Query("select * " +
            "from CreatedComponent c " +
            "where c.createdComponentId = ?1 ")
    Diary findByCreatedComponentId(String cid);
}
