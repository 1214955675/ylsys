package com.bs.sys.dao;

import com.bs.sys.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wwj
 * 2019/4/16 15:39
 */
public interface MessageDao {
    @Insert("insert into message (fromId,fromName,toId,messageText,messageDate,formatDate) " +
            "values (#{fromId},#{fromName},#{toId},#{messageText},#{messageDate},#{formatDate})")
    void addmess(Message message);
    @Select("select * from message where fromId = #{userId} and messageDate > #{now} union all  select * from message where toId = #{userId} and messageDate > #{now}")
    List<Message> getmsg(@Param("userId") Integer userId,@Param("now") long time);
    @Select("select * from message where fromId = #{userId} and messageDate > #{fromtime} and messageDate<#{totime} " +
            "union all  select * from message where toId = #{userId} and messageDate > #{fromtime} and messageDate<#{totime}")
    List<Message> getmsgbytime(@Param("userId") Integer userId,@Param("fromtime") long fromtime,@Param("totime") long totime);
    @Select("select toId from message where fromId = #{userId}  " +
            "union all  select fromId from message where toId = #{userId} ")
    List<Integer> getyourchat(int userId);
    @Select("select * from message where fromId = #{userId} and toId =#{whoId} and messageDate > #{now} " +
            "union all  select * from message where toId = #{userId} and fromId =#{whoId} and messageDate > #{now}")
    List<Message> getmsgbywho(@Param("userId") int userId,@Param("whoId") int whoId,@Param("now") long time);
    @Select("select * from message where fromId = #{userId} and toId=#{whoId} and messageDate > #{fromtime} and messageDate<#{totime} " +
            "union all  select * from message where toId = #{userId} and fromId=#{whoId} and messageDate > #{fromtime} and messageDate<#{totime}")
    List<Message> getmsgbywhotime(@Param("userId") Integer userId,@Param("whoId") Integer whoId,@Param("fromtime") long fromtime,@Param("totime") long totime);
}
