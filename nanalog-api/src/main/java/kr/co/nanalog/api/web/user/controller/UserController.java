package kr.co.nanalog.api.web.user.controller;

import kr.co.nanalog.api.web.user.model.request.UserCreateRequest;
import kr.co.nanalog.api.web.user.model.request.UserDeleteRequest;
import kr.co.nanalog.api.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity createUser(@Valid UserCreateRequest userCreateRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_ACCEPTABLE);
        }

        int resultCode = userService.createUser(userCreateRequest);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public ResponseEntity deleteUser(@Valid UserDeleteRequest userDeleteRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity("에러 메시지", HttpStatus.NOT_ACCEPTABLE);
        }

        int resultCode = userService.deleteUser(userDeleteRequest);

        return new ResponseEntity(HttpStatus.OK);
    }
}
