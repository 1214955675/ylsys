package com.bs.sys.dao;

import com.bs.sys.entity.Topic;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wwj
 * 2019/3/28 13:18
 */
@Component
public interface TopicDao {
    @Insert("INSERT INTO topic (topicName,postNum, imgUrl) VALUES (#{topicName}, #{postNum}, #{imgUrl})")
    void addtopic(Topic topic);
    @Delete("delete from topic where id = #{id}")
    int deltopic(int id);
    @Select("select id ,topicName from topic limit #{page},#{limit}")
    List<Topic> getalltopic(@Param("page")int page,@Param("limit")int limit);
    @UpdateProvider(type=com.bs.sys.common.DynoSqlProvider.class,method="updateTopicSql")
    int updatetopic(Topic topic);
    @Select("select * from topic where topicName like CONCAT('%',#{key},'%') ")
    List<Topic> searchall(String key);
}
