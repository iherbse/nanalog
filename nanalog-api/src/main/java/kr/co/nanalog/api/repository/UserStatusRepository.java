package kr.co.nanalog.api.repository;

import kr.co.nanalog.api.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {
}
