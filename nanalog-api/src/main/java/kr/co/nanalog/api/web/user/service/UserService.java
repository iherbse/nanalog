package kr.co.nanalog.api.web.user.service;

import kr.co.nanalog.api.entity.User;
import kr.co.nanalog.api.web.user.model.request.UserCreateRequest;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
public interface UserService {

    public Integer createUser(UserCreateRequest userCreateRequest);

    public User login(String uid, String password);
}
