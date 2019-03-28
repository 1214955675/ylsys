package com.bs.sys.common.response;

import com.bs.sys.entity.Topic;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author wwj
 * 2019/3/28 13:08
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicResponse extends BaseResponse{
    private Topic topic;
    private List<Topic> topicList;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
