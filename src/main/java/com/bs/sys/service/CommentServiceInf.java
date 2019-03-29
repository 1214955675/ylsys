package com.bs.sys.service;

import com.bs.sys.entity.Comment;

import java.util.List;

/**
 * @author wwj
 * 2019/3/29 10:34
 */
public interface CommentServiceInf {
    int addcomment(Comment comment);
    List<Comment> getcommentsbypostid(int topicid);
}
