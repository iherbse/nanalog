package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.Component;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
public interface ComponentRepository {

    @Query("select * " +
            "from Contents c " +
            "where c.cid = ?1 ")
    Component findByComponentId(String cid);
}
