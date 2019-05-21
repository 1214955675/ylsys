package com.bs.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwj
 * 2019/4/15 10:20
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post implements Comparable<Post>{
    private Integer id;
    private String postName;
    private String content;
    private Long createTime;
    private Integer topicId;
    private Integer clickNum;
    private String postImg;
    private int tasteCountForPerson;

    public int getTasteCountForPerson() {
        return tasteCountForPerson;
    }

    public void setTasteCountForPerson(int tasteCountForPerson) {
        this.tasteCountForPerson = tasteCountForPerson;
    }

    @Override
    public int compareTo(Post post) {           //重写Comparable接口的compareTo方法，
        return  post.getTasteCountForPerson()-this.tasteCountForPerson ;   // 根据用户自己的兴趣点击量降序排列，降序修改相减顺序即可
    }
    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

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
