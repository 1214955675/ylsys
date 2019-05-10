package com.bs.sys.dao;

import com.bs.sys.entity.Advice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wwj
 * 2019/4/15 18:24
 */
public interface AdviceDao {
    @Insert("insert into advice (createTime,content,contactWay,isDeal) " +
            "values (#{createTime},#{content},#{contactWay},#{isDeal})")
    int addAdvice(Advice advice);
    @Select("select * from advice limit #{page},#{limit}")
    List<Advice> getadvices(@Param("page") int page, @Param("limit") int limit);
    @Update("update advice set isDeal = 1 where id =#{id}")
    int dealadvice(int id);
    @Select("select * from advice where id =#{id}")
    Advice getbyid(int id);
}
