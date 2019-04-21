package com.bs.sys.service;

import com.bs.sys.entity.Post;
import javafx.geometry.Pos;

import java.util.List;

/**
 * @author wwj
 * 2019/4/15 10:41
 */
public interface PostService {
    List<Post> getpostbytopicid(Integer topicid);
    int createPost(Post post);
    boolean delPost(Integer postid);
    boolean updatepost(Post post);
    Post getpostbypostid(Integer id);
}
