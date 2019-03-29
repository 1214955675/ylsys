package com.bs.sys.service.impl;

import com.bs.sys.dao.CommentDao;
import com.bs.sys.entity.Comment;
import com.bs.sys.service.CommentServiceInf;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wwj
 * 2019/3/29 10:35
 */
@Service
public class CommentServiceImpl implements CommentServiceInf {
    @Resource
    CommentDao commentDao;
    @Override
    public int addcomment(Comment comment) {
        try {
           return commentDao.addcomment(comment);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Comment> getcommentsbypostid(int topicid) {
        try {
            List<Comment> list=commentDao.findcommentsbypostid(topicid);
            sort(list, 0);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    public static void sort(List<Comment> list,int tocommentid){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getToCommentId()==tocommentid){
                System.out.println(list.get(i).getId());
                sort(list, list.get(i).getId());
            }
        }
    }
}
