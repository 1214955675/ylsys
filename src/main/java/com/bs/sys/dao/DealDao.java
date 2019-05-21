package com.bs.sys.dao;

import com.bs.sys.entity.Deal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@Component
public interface DealDao {
    @Insert("insert into deal (content,adviceId,dealTime) values (#{content},#{adviceId},#{dealTime})")
    void adddeal(Deal deal);
    @Select("select * from deal  limit #{page},#{limit} ")
    List<Deal> getalldeal(@Param("page")int page, @Param("limit")int limit);
    @Select("select * from deal  where adviceId = #{adviceId} ")
    Deal getdealbyadviceid(int adviceId);
}
