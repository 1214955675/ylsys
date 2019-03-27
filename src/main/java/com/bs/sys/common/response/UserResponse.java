package com.bs.sys.common.response;

import com.bs.sys.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

/**
 * @author wwj
 * 2019/3/26 18:09
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse<T> extends BaseResponse{
    private T user;
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Object getObject() {
        return user;
    }

    public void setObject(T user) {
        this.user =  user;
    }
}
