package kr.co.nanalog.api.web.user.service;

import kr.co.nanalog.api.entity.User;
import kr.co.nanalog.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String uid, String password) {
        User user = userRepository.findByUidAndPassword(uid, password);

        System.out.println(user.toString());
        return user;
    }
}
