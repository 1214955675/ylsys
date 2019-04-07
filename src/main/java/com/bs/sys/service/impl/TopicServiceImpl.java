package com.bs.sys.service.impl;

import com.bs.sys.dao.TopicDao;
import com.bs.sys.entity.Topic;
import com.bs.sys.service.TopicServiceInf;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu Min
 * 2019/3/28 13:17
 */
@Service
public class TopicServiceImpl implements TopicServiceInf {
    @Resource
    TopicDao topicDao;
    @Override
    public int addTopic(Topic topic) {
        int resint=0;
        try {
            topicDao.addtopic(topic);
            resint=topic.getId();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resint;
    }

    @Override
    public List<Topic> getalltopic(int page,int limit) {
        List<Topic> res=new ArrayList<Topic>();
        try {
            res=topicDao.getalltopic((page-1)*limit, limit);
        }catch (Exception e){
            e.printStackTrace();
            res=null;
        }
        return res;
    }

    @Override
    public boolean delTopicbyid(int id) {
        try {
            if(topicDao.deltopic(id)>0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatetopicbyid(Topic topic) {
        try {
            int count=topicDao.updatetopic(topic);
            if(count>0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
