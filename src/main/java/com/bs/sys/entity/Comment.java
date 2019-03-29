package com.bs.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Time;

/**
 * @author wwj
 * 2019/3/29 10:22
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comment {
    private Integer id;
    private Integer fromUserId;
    private String fromUserName;
    private String fromUserImg;
    private Integer toCommentId;
    private Integer toPostId;
    private String content;
    private Long commentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getFromUserImg() {
        return fromUserImg;
    }

    public void setFromUserImg(String fromUserImg) {
        this.fromUserImg = fromUserImg;
    }

    public Integer getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(Integer toCommentId) {
        this.toCommentId = toCommentId;
    }

    public Integer getToPostId() {
        return toPostId;
    }

    public void setToPostId(Integer toPostId) {
        this.toPostId = toPostId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Long commentTime) {
        this.commentTime = commentTime;
    }
}
