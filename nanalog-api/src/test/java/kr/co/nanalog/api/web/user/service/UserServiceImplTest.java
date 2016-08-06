package kr.co.nanalog.api.web.user.service;

import kr.co.nanalog.api.web.user.model.entity.User;
import kr.co.nanalog.api.web.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {


    @Mock
    private static UserRepository userRepository;

    @InjectMocks
    private static UserService userService = new UserServiceImpl();

    @Test
    public void createUser() throws Exception {

        System.out.println(getCurrentDate());
        User user = new User();
        user.setUid("test@test.com");
        user.setName("test name");
        user.setPassword("123456");
        user.setRegistrationDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        user.setPermission("USER");
        user.setActive(true);

        Mockito.when(userRepository.save(user)).thenReturn(user);

        System.out.println(user.toString());
    }

    private String getCurrentDate(){
        return LocalDateTime.now().plusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}