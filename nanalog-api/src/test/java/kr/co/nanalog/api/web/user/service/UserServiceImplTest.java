package kr.co.nanalog.api.web.user.service;

import kr.co.nanalog.api.entity.User;
import kr.co.nanalog.api.entity.UserStatus;
import kr.co.nanalog.api.repository.UserRepository;
import kr.co.nanalog.api.repository.UserStatusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private static UserRepository userRepository;
    @Mock
    private static UserStatusRepository userStatusRepository;

    @InjectMocks
    private static UserService userService = new UserServiceImpl();


    @Test
    public void jpaRelationTest() throws Exception {
        User user = new User();

        user.setUid("TEST");
        user.setPassword("test");

        UserStatus userStatus = new UserStatus();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Mockito.when(userStatusRepository.findOne(user.getId())).thenReturn(userStatus);

        System.out.println(user.toString());
        System.out.println(userStatus.toString());
   }

}