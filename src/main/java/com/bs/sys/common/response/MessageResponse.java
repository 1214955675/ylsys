package com.bs.sys.common.response;

import com.bs.sys.entity.Message;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse extends  BaseResponse{
    private List<Message> messageList;

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
