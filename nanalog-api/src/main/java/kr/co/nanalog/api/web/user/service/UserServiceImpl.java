package kr.co.nanalog.api.web.user.service;

import kr.co.nanalog.api.entity.User;
import kr.co.nanalog.api.entity.UserDeleteQueue;
import kr.co.nanalog.api.repository.UserDeleteQueueRepository;
import kr.co.nanalog.api.repository.UserRepository;
import kr.co.nanalog.api.web.user.model.request.UserCreateRequest;
import kr.co.nanalog.api.web.user.model.request.UserDeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDeleteQueueRepository userDeleteQueueRepository;

    @Override
    public Integer createUser(UserCreateRequest userCreateRequest) {

        String uid = userCreateRequest.getUid();

        User user = this.userRepository.findByUid(uid);

        if(user != null && user.getUid().equals(uid)){
            return -1;
        }

        String name = userCreateRequest.getName();
        String password = userCreateRequest.getPassword();
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        user = new User();
        user.setUid(uid);
        user.setName(name);
        user.setPassword(password);
        user.setRegistrationDate(currentTime);
        user.setActive(true);
        user.setPermission("USER");

        this.userRepository.save(user);

        return 1;
    }

    @Override
    public Integer deleteUser(UserDeleteRequest userDeleteRequest) {

        String uid = userDeleteRequest.getUid();
        String password = userDeleteRequest.getPassword();

        User user = this.userRepository.findByUid(uid);

        if(user != null && !(user.getPassword().equals(password))){
            return -1;
        }
        else if(user == null){
            return 0;
        }

        String deleteDate = LocalDateTime.now().plusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        UserDeleteQueue userDeleteQueue = new UserDeleteQueue();
        userDeleteQueue.setUid(uid);
        userDeleteQueue.setDeleteDate(deleteDate);

        this.userDeleteQueueRepository.save(userDeleteQueue);

        return 1;
    }
}
