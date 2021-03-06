package com.bs.sys.service;

import com.bs.sys.entity.Post;

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
    List<Post> searchall(String key);
    List<Post> gethotpost(int page, int limit);
}
