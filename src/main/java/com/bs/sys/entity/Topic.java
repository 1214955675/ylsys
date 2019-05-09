package com.bs.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwj
 * 2019/3/28 12:48
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Topic implements Comparable<Topic>{
    private Integer id;
    private String topicName;
    private String postNum;
    private String imgUrl;
    private int tasteCountForPerson;
    @Override
    public int compareTo(Topic topic) {           //重写Comparable接口的compareTo方法，
        return  topic.getTasteCountForPerson()-this.tasteCountForPerson ;   // 根据用户自己的兴趣点击量降序排列，降序修改相减顺序即可
    }
    public int getTasteCountForPerson() {
        return tasteCountForPerson;
    }

    public void setTasteCountForPerson(int tasteCountForPerson) {
        this.tasteCountForPerson = tasteCountForPerson;
    }

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
