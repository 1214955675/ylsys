package com.bs.sys.common.request;

import com.bs.sys.entity.User;

/**
 * @author wwj
 * 2019/3/27 11:26
 */
public class UserReq extends User {
    private String newpwd;

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }
}
