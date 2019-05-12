package com.bs.sys.service;

import com.bs.sys.entity.Topic;

import java.util.List;

/**
 * @author wwj
 * 2019/3/28 13:16
 */
public interface TopicServiceInf {
    int addTopic(Topic topic);
    boolean delTopicbyid(int id);
    List<Topic> getalltopic(int page,int limit);
    boolean updatetopicbyid(Topic topic);
    void addclicknum(int id);
    List<Topic> searchall(String key);
}
