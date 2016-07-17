package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u " +
            "from User u " +
            "where u.uid = ?1 ")
    public User findByUid(String uid);

    @Query("select u " +
            "from User u " +
            "where u.uid = ?1 " +
            "and u.password = ?2 ")
    public User findByUidAndPassword(String uid, String password);
}
