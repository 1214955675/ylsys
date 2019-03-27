package com.bs.sys.dao;

import com.bs.sys.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@Mapper
@Component
public interface UserDao {
    @Select("select * from user where userName=#{userName}")
    User findbyusername(String userName);
    @Insert("INSERT INTO user (userName,nickName, passWord,phone) VALUES (#{userName}, #{nickName}, #{passWord},#{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="id")
    Integer adduser(User user);
    @Select("select id from user where userName=#{userName} and passWord=#{passWord}")
    Integer checkLogin(User user);
    @Select("select * from user where id =#{id}")
    User findbyid(Integer id);
    @UpdateProvider(type=com.bs.sys.common.DynoSqlProvider.class,method="updateEmployeeSql")
    Integer updateuser(User user);
}
