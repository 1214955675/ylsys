package com.bs.sys.common;

import com.bs.sys.entity.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class DynoSqlProvider {
    //方法中的关键字是区分大小写的  SQL SELECT WHERE
    //该方法会根据传递过来的map中的参数内容  动态构建sql语句
    public String insertEmployeeSql(final User user) {
        return new SQL() {
            {
                INSERT_INTO("user");
                if(user.getId()!=null) {
                    VALUES("id","#{id}");
                }
                if(user.getUserName()!=null){
                    VALUES("userName","userName");
                }
                if(user.getNickName()!=null) {
                    VALUES("nickName", "#{nickName}");
                }
                if(user.getPassWord()!=null) {
                    VALUES("passWord", "#{passWord}");
                }
                if(user.getPhone()!=null) {
                    VALUES("phone", "#{phone}");
                }
            }
        }.toString();

    }
    public String updateEmployeeSql(final User user) {
        return new SQL() {
            {
                UPDATE("user");
                if(user.getId()!=null) {
                    SET("id=#{id}");
                }
                if(user.getUserName()!=null) {
                    SET("userName=#{userName}");
                }
                if(user.getNickName()!=null) {
                    SET("nickName=#{nickName}");
                }
                if(user.getPassWord()!=null) {
                    SET("passWord=#{passWord}");
                }
                if(user.getPhone()!=null) {
                    SET("phone=#{phone}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
