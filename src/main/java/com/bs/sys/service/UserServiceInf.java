package com.bs.sys.service;

import com.bs.sys.entity.User;

/**
 * @author Hu Min
 * 2019/3/26 18:12
 */
public interface UserServiceInf {
    boolean checkUserexist(String username);
    Integer createUser(User user);
}
