package kr.co.nanalog.api.web.user.repository;

import kr.co.nanalog.api.web.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u " +
            "from User u " +
            "where u.uid = ?1 ")
    User findByUid(String uid);

    @Modifying
    @Query("update User u set u.active = ?1 where u.uid = ?2")
    void setUserActiveByUid(boolean active, String uid);
}