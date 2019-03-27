package com.bs.sys.service.impl;

import com.bs.sys.dao.UserDao;
import com.bs.sys.entity.User;
import com.bs.sys.service.UserServiceInf;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wwj
 * 2019/3/26 18:25
 */
@Service
public class UserServiceImpl implements UserServiceInf {
    @Resource
    UserDao userDao;
    @Override
    public boolean checkUserexist(String username) {
        User user=userDao.findbyusername(username);
        if(user==null){
            return false;
        }else
            return true;
    }

    @Override
    public Integer createUser(User user) {
        if(user==null){
            return 0;
        }
        int result=0;
        try {
            result=userDao.adduser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result>0){
            return user.getId();
        }else
            return 0;
    }

    @Override
    public Integer findbyNameandpwd(User user) {
        try {
            return userDao.checkLogin(user);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public User findbyid(Integer id) {
        try {
            User user=userDao.findbyid(id);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean updatepwd(User user) {

        return false;
    }
}
