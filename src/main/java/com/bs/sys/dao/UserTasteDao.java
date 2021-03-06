package com.bs.sys.dao;

import com.bs.sys.entity.Listbysql;
import com.bs.sys.entity.userTaste;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserTasteDao {
    @Insert("INSERT INTO usertaste (userId,collectTime, topicId,postId) VALUES (#{userId}, #{collectTime}, " +
            "#{topicId},#{postId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="id")
    Integer addusertaste(userTaste usertaste);
    @Select("select topicId as objectid,count(id) as count from usertaste where userId = #{userId} GROUP BY topicId ORDER BY count(id) DESC ")
    List<Listbysql> getbyuserid(Integer userId);
    @Select("select postId as objectid,count(id) as count from usertaste where userId = #{userId} GROUP BY postId ORDER BY count(id) DESC ")
    List<Listbysql> getpostidbyuserid(Integer userId);
}
