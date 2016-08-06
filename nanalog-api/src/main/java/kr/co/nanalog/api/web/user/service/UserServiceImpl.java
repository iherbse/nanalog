package kr.co.nanalog.api.web.user.service;

import kr.co.nanalog.api.web.user.model.entity.User;
import kr.co.nanalog.api.web.user.model.entity.UserDeleteQueue;
import kr.co.nanalog.api.web.user.repository.UserDeleteQueueRepository;
import kr.co.nanalog.api.web.user.repository.UserRepository;
import kr.co.nanalog.api.web.user.model.request.UserCreateRequest;
import kr.co.nanalog.api.web.user.model.request.UserDeleteRequest;
import kr.co.nanalog.api.web.user.model.request.UserUpdateRequest;
import kr.co.nanalog.api.web.user.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@Service
@Transactional
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
        String currentTime = getCurrentDate();

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
    public Integer updateUser(UserUpdateRequest userUpdateRequest) {

        String uid = userUpdateRequest.getUid();
        String name = userUpdateRequest.getName();
        String password = userUpdateRequest.getPassword();

        User user = this.userRepository.findByUid(uid);

        if(user != null && !(user.getPassword().equals(password))){
            return -1;
        }
        else if(user == null){
            return 0;
        }

        user.setUid(uid);
        user.setName(name);
        user.setPassword(password);

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
        else if(user.isActive() == false){
            return -2;
        }

        String deleteDate = getCurrentDate();

        UserDeleteQueue userDeleteQueue = new UserDeleteQueue();
        userDeleteQueue.setUid(uid);
        userDeleteQueue.setDeleteDate(deleteDate);

        user.setActive(false);

        this.userRepository.save(user);
        this.userDeleteQueueRepository.save(userDeleteQueue);

        return 1;
    }

    @Override
    public UserResponse readUser(String uid) {

        User user = this.userRepository.findByUid(uid);

        if(user == null){
            return null;
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setUid(uid);
        userResponse.setName(user.getName());
        userResponse.setPermission(user.getPermission());
        userResponse.setActive(user.isActive());
        userResponse.setRegistrationDate(user.getRegistrationDate());

        return userResponse;
    }

    @Override
    public Integer updateUserActiveState(String uid) {
        User user = this.userRepository.findByUid(uid);

        if(user == null){
            return -1;
        }

        boolean active = user.isActive();

        if(active == true){
            user.setActive(false);
            String currentTime = getCurrentDate();

            UserDeleteQueue userDeleteQueue = new UserDeleteQueue();
            userDeleteQueue.setId(user.getId());
            userDeleteQueue.setUid(user.getUid());
            userDeleteQueue.setDeleteDate(currentTime);
            this.userDeleteQueueRepository.save(userDeleteQueue);
        }
        else{
            user.setActive(true);
            this.userDeleteQueueRepository.delete(user.getId());
        }

        this.userRepository.setUserActiveByUid(user.isActive(), uid);

        return 1;
    }

    @Override
    public UserDeleteQueue readUserActiveState(String uid) {

        User user = this.userRepository.findByUid(uid);

        if(user == null){
            return null;
        }

        UserDeleteQueue userDeleteQueue = this.userDeleteQueueRepository.findOne(user.getId());

        if(userDeleteQueue == null){
            return null;
        }

        return userDeleteQueue;
    }

    @Override
    public Integer deleteUserDeleteQueue(String uid) {

        User user = this.userRepository.findByUid(uid);

        if(user == null){
            return -1;
        }

        UserDeleteQueue userDeleteQueue = this.userDeleteQueueRepository.findOne(user.getId());

        if(userDeleteQueue == null) {
            return -2;
        }

        this.userDeleteQueueRepository.delete(userDeleteQueue);

        return 1;
    }

    private String getCurrentDate(){
        return LocalDateTime.now().plusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
