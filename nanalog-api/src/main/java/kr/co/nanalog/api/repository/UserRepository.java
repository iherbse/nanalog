package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.User;
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
    @Query("update User u set u.name = ?1, u.password = ?2 where u.uid = ?3")
    void setUserByUid(String name, String password, String uid);
}
