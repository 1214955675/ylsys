package com.bs.sys.service.impl;

import com.bs.sys.dao.MessageDao;
import com.bs.sys.entity.Message;
import com.bs.sys.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wwj
 * 2019/4/16 15:38
 */
@Service(value = "messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageDao messageDao;
    @Override
    public void addmessage(Message message) {
        try {
            messageDao.addmess(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Message> getmsg(int userId, long now) {

        return messageDao.getmsg(userId, now);
    }

    @Override
    public List<Message> getmsgbytime(int userId, long fromtime, long totime) {

        return messageDao.getmsgbytime(userId,fromtime,totime);
    }

    @Override
    public List<Integer> getyourchat(int userId) {

        return messageDao.getyourchat(userId);
    }

    @Override
    public List<Message> getmsgbywho(int userId, int whoId,long time) {

        return messageDao.getmsgbywho(userId,whoId,time);
    }

    @Override
    public List<Message> getmsgbywhotime(int userId, int whoId, long fromtime, long totime) {
        return messageDao.getmsgbywhotime(userId,whoId,fromtime,totime);
    }
}
