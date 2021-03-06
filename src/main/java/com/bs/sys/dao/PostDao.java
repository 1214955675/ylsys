package com.bs.sys.dao;

import com.bs.sys.entity.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wwj
 * 2019/4/15 10:42
 */
@Component
public interface PostDao {
    @Select("select * from post where topicId = #{topicId}")
    List<Post> getpostbytopicid(Integer topicId);
    @Insert("insert into post (postName,createTime,topicId,content,postImg ,clickNum) " +
            "values (#{postName},#{createTime},#{topicId},#{content},#{postImg},0)")
    int insertPost(Post post);
    @Delete("delete from post where id =#{id}")
    int delpost(int id);
    @UpdateProvider(type=com.bs.sys.common.DynoSqlProvider.class,method="updatePostSql")
    int updatepost(Post post);
    @Select("select * from post where id =#{id}")
    Post getpostbypostid(Integer postid);
    @Select("select * from post where postName like CONCAT('%',#{key},'%') or content like CONCAT('%',#{key},'%') ")
    List<Post> searchpost(String key);
    void addclicknum(int id);
    @Select("select * from post  ORDER BY clickNum limit #{page},#{limit} ")
    List<Post> gethotpost(@Param("page")int page, @Param("limit")int limit);
}
