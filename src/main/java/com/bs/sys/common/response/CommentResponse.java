package com.bs.sys.common.response;

import com.bs.sys.entity.Comment;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author wwj
 * 2019/3/29 10:32
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponse extends BaseResponse{
    private Comment comment;
    private List<Comment> commentList;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
