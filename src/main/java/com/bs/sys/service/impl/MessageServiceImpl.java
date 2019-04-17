package com.bs.sys.service.impl;

import com.bs.sys.dao.MessageDao;
import com.bs.sys.entity.Message;
import com.bs.sys.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wwj
 * 2019/4/16 15:38
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    MessageDao messageDao;
    @Override
    public void addmessage(Message message) {
        try {
            messageDao.addmess(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
