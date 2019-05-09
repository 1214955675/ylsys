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
    @Insert("INSERT INTO usertaste (userId,collectTime, topicId) VALUES (#{userId}, #{collectTime}, " +
            "#{topicId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="id")
    Integer addusertaste(userTaste usertaste);
    @Select("select topicId,count(*) as count from usertaste where userId = #{userId} GROUP BY topicId ")
    List<Listbysql> getbyuserid(Integer userId);
}
