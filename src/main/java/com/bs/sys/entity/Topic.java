package com.bs.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwj
 * 2019/3/28 12:48
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Topic {
    private Integer id;
    private String topicName;
    private String postNum;
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
