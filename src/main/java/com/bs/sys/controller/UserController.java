package com.bs.sys.controller;

import com.bs.sys.common.response.UserResponse;
import com.bs.sys.entity.User;
import com.bs.sys.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wwj
 * 2019/3/26 18:02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserServiceImpl userService;

    @RequestMapping(value = "/register")
    public UserResponse register(User user){
        UserResponse res=new UserResponse();
        if(!userService.checkUserexist(user.getUserName())){

        }
        return res;
    }
}
