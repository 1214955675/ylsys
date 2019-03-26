package com.bs.sys.dao;

import com.bs.sys.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@Mapper
public interface UserDao {
    @Select("select * from user where userName=#{userName}")
    User findbyusername(String userName);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO user (userName,nickName, passWord) VALUES (#{userName}, #{nickName}, #{passWord})")
    Integer adduser(User user);
}
