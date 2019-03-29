package com.bs.sys.dao;

import com.bs.sys.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wwj
 * 2019/3/29 10:35
 */
@Component
public interface CommentDao {
    @Insert("insert into comment (fromUserId,fromUserName,fromUserImg,toCommentId,toPostId,content,commentTime) " +
            "values (#{fromUserId},#{fromUserName},#{fromUserImg},#{toCommentId},#{toPostId},#{content},#{commentTime})")
    int addcomment(Comment comment);
    @Select("select * from comment where toPostId =#{postId}")
    List<Comment> findcommentsbypostid(int postId);

}
