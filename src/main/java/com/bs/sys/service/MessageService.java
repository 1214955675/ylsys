package com.bs.sys.service;

import com.bs.sys.entity.Message;

import java.util.List;

/**
 * @author wwj
 * 2019/4/16 15:37
 */
public interface MessageService {
    void addmessage(Message message);
    List<Message> getmsg(int userId,long now);
    List<Message> getmsgbytime(int userId,long fromtime,long totime);
    List<Integer> getyourchat(int userId);
    List<Message> getmsgbywho(int userId,int whoId,long time);
    List<Message> getmsgbywhotime(int userId,int whoId,long fromtime,long totime);
}
