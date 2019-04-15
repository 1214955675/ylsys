package com.bs.sys.service.impl;

import com.bs.sys.dao.PostDao;
import com.bs.sys.entity.Post;
import com.bs.sys.service.PostService;
import javafx.geometry.Pos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wwj
 * 2019/4/15 10:42
 */
@Service
public class PostServiceImpl implements PostService {
    @Resource
    PostDao postDao;

    @Override
    public List<Post> getpostbytopicid(Integer topicid) {
        List<Post> postlist=postDao.getpostbytopicid(topicid);

        return postlist;
    }

    @Override
    public int createPost(Post post) {
        int result=postDao.insertPost(post);
        if(result<=0){
            return 0;
        }else
        return result;
    }

    @Override
    public boolean delPost(Integer postid) {
        int result=postDao.delpost(postid);
        if(result>0){
            return true;
        }else
        return false;
    }

    @Override
    public boolean updatepost(Post post) {
        int result=postDao.updatepost(post);
        if(result>0){
            return true;
        }else
        return false;
    }
}
