package com.bs.sys.common.response;

import com.bs.sys.entity.User;

import java.util.List;

/**
 * @author Hu Min
 * 2019/3/26 18:09
 */
public class UserResponse extends BaseResponse{
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
