package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.request.UserReq;
import com.bs.sys.common.response.UserResponse;
import com.bs.sys.entity.User;
import com.bs.sys.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.invoke.MethodType;

/**
 * @author wwj
 * 2019/3/26 18:02
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserServiceImpl userService;
    @RequestMapping(value = "/test")
    public void atest(String in){
        System.out.println(in);
        return ;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public UserResponse register(User user){
        UserResponse<User> res=new UserResponse();
        if(!userService.checkUserexist(user.getUserName())){
            if(userService.createUser(user)>0){
                User resuser=new User();
                resuser.setId(user.getId());
                res.setObject(resuser);
                return res;
            }
        }else {
            res.setResultCode(ResultCode.user_exist_error.getCode());
            res.setResultMessage(ResultCode.user_exist_error.getMessage());
            return res;
        }
        res.setResultCode(500);
        res.setResultMessage("注册失败");
        return res;
    }
    @ResponseBody
    @RequestMapping("/login")
    public UserResponse login(UserReq userReq){
        UserResponse res=new UserResponse();
        int resint=userService.findbyNameandpwd(userReq);
        if(resint>0){
            res.setObject(resint);
            return res;
        }else{
            res.setResultCode(ResultCode.user_notexist.getCode());
            res.setResultMessage(ResultCode.user_notexist.getMessage());
            return res;
        }
    }
    @ResponseBody
    @RequestMapping("/updatePwd")
    public UserResponse updatepwd(UserReq userReq,String newpwd){
        UserResponse res=new UserResponse();
        userService.findbyNameandpwd(userReq);
        if(userReq.getId()>0){
            if(userService.updatepwd(userReq.getId(), newpwd)){

            }
        }
        if(ownuser==null){
            res.setResultMessage(ResultCode.user_notexist.getMessage());
            res.setResultCode(ResultCode.user_notexist.getCode());
            return res;
        }else {

        }
    }
}
