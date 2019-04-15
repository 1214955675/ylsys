package com.bs.sys.dao;

import com.bs.sys.entity.Advice;
import com.bs.sys.entity.Comment;
import org.apache.ibatis.annotations.Insert;

/**
 * @author wwj
 * 2019/4/15 18:24
 */
public interface AdviceDao {
    @Insert("insert into advice (createTime,content,contactWay,isDeal) " +
            "values (#{createTime},#{content},#{contactWay},#{isDeal})")
    int addAdvice(Advice advice);
}
