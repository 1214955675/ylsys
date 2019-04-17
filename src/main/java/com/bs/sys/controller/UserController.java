package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.request.UserReq;
import com.bs.sys.common.response.UserResponse;
import com.bs.sys.entity.User;
import com.bs.sys.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodType;
import java.util.UUID;

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
    public UserResponse register(User user, @RequestParam(value = "file",required = false) CommonsMultipartFile file) throws IOException {
        UserResponse<User> res=new UserResponse();
        if(!userService.checkUserexist(user.getUserName())){
            if(file!=null){
                String uuid=UUID.randomUUID().toString();
                File newfile=
                        new File("D:/opt/img/"+uuid+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')));
                file.transferTo(newfile);
                user.setUserImg(newfile.getAbsolutePath());
            }
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
    public UserResponse login(HttpServletRequest request,UserReq userReq){
        UserResponse res=new UserResponse();
        int resint=userService.findbyNameandpwd(userReq);
        if(resint>0){
            res.setObject(resint);
            HttpSession session = request.getSession();
            session.setAttribute("user", userReq);
            return res;
        }else{
            res.setResultCode(ResultCode.user_notexist.getCode());
            res.setResultMessage(ResultCode.user_notexist.getMessage());
            return res;
        }
    }
    @ResponseBody
    @RequestMapping("/updatePwd")
    public UserResponse updatepwd(UserReq userReq,@RequestParam("newpwd") String newpwd){
        UserResponse res=new UserResponse();
        int findid=userService.findbyNameandpwd(userReq);
        if(findid>0){
            userReq.setId(findid);
            userReq.setPassWord(newpwd);
            if(userService.updateUser(userReq)){
                return res;
            }else{
                res.setResultMessage(ResultCode.db_opterror.getMessage());
                res.setResultCode(ResultCode.db_opterror.getCode());
                return res;
            }
        }
        res.setResultMessage(ResultCode.user_notexist.getMessage());
        res.setResultCode(ResultCode.user_notexist.getCode());
        return res;
    }
    @ResponseBody
    @RequestMapping("/updateUser")
    public UserResponse updateuser(UserReq userReq,
                                   @RequestParam(value = "file",required = false)CommonsMultipartFile file) throws IOException {
        UserResponse res=new UserResponse();
        int findid=userService.findbyNameandpwd(userReq);
        if(findid>0){
            userReq.setId(findid);
            userReq.setNickName(userReq.getNickName());
            if(file!=null){
                String uuid=UUID.randomUUID().toString();
                File newfile=
                        new File("D:/opt/img/"+uuid+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')));
                file.transferTo(newfile);
                userReq.setUserImg(newfile
                .getAbsolutePath());
            }
            if(userService.updateUser(userReq)){
                return res;
            }else{
                res.setResultMessage(ResultCode.db_opterror.getMessage());
                res.setResultCode(ResultCode.db_opterror.getCode());
                return res;
            }
        }
        return res;
    }
}
