package kr.co.nanalog.api.web.user.service;

import kr.co.nanalog.api.web.user.model.request.UserCreateRequest;
import kr.co.nanalog.api.web.user.model.request.UserDeleteRequest;
import kr.co.nanalog.api.web.user.model.request.UserUpdateRequest;
import kr.co.nanalog.api.web.user.model.response.UserResponse;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
public interface UserService {

    Integer createUser(UserCreateRequest userCreateRequest);

    Integer updateUser(UserUpdateRequest userUpdateRequest);

    Integer deleteUser(UserDeleteRequest userDeleteRequest);

    UserResponse readUser(String uid);
}
