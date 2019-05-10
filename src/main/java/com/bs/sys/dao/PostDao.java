package com.bs.sys.dao;

import com.bs.sys.entity.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
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
    @Insert("insert into post (postName,createTime,topicId,content,postImg) " +
            "values (#{postName},#{createTime},#{topicId},#{content},#{postImg})")
    int insertPost(Post post);
    @Delete("delete from post where id =#{id}")
    int delpost(int id);
    @UpdateProvider(type=com.bs.sys.common.DynoSqlProvider.class,method="updatePostSql")
    int updatepost(Post post);
    @Select("select * from post where id =#{id}")
    Post getpostbypostid(Integer postid);

    void addclicknum(int id);
}
