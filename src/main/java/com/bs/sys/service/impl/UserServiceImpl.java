package com.bs.sys.service.impl;

import com.bs.sys.entity.User;
import com.bs.sys.service.UserServiceInf;
import org.springframework.stereotype.Service;

/**
 * @author wwj
 * 2019/3/26 18:25
 */
@Service
public class UserServiceImpl implements UserServiceInf {

    @Override
    public boolean checkUserexist(String username) {
        return false;
    }

    @Override
    public Integer createUser(User user) {
        return null;
    }
}
