package com.bs.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwj
 * 2019/4/15 10:20
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {
    private Integer id;
    private String postName;
    private String content;
    private Long createTime;
    private Integer topicId;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
