package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.response.PostResponse;
import com.bs.sys.entity.Post;
import com.bs.sys.entity.userTaste;
import com.bs.sys.service.impl.PostServiceImpl;
import com.bs.sys.service.impl.userTasteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wwj
 * 2019/4/15 10:24
 */
@Controller
@ResponseBody
@RequestMapping("/post")
public class PostController {
    @Resource
    PostServiceImpl postService;

    @Resource
    userTasteServiceImpl userTasteService;
    @RequestMapping("/createPost")
    public PostResponse createPost(Post post){
        PostResponse res=new PostResponse();
        post.setCreateTime(System.currentTimeMillis());
        int createint=postService.createPost(post);
        if(createint==0){
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/getPostByPostId")
    public PostResponse getPostByPostId(@RequestParam String postId,@RequestParam(value = "userId",required = false)String userId,
                                        @RequestParam(value = "topicId",required = false) String topicId){
        PostResponse res=new PostResponse();
        try {
            int post_id=Integer.parseInt(postId);
            res.setPost(postService.getpostbypostid(post_id));
            //收集兴趣
            userTaste userTaste=new userTaste();
            userTaste.setCollectTime(System.currentTimeMillis());
            if(topicId!=null&&userId!=null){
                int topic=Integer.parseInt(topicId);
                int userId_int=Integer.parseInt(userId);
                userTaste.setUserId(userId_int);
                userTaste.setTopicId(topic);
                if(!userTasteService.addtaste(userTaste)){
                    res.setResultCode(ResultCode.db_opterror.getCode());
                    res.setResultMessage(ResultCode.db_opterror.getMessage());
                    return res;
                }else {
                    return res;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/getPostByTopicId")
    public PostResponse getPostByTopicId(@RequestParam String topicId){
        PostResponse res=new PostResponse();
        try {
            int topic_id=Integer.parseInt(topicId);
            List<Post> list=postService.getpostbytopicid(topic_id);
            res.setPostlist(list);

            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.setResultCode(ResultCode.data_parse_error.getCode());
            res.setResultMessage(ResultCode.data_parse_error.getMessage());
            return res;
        }
    }
    @RequestMapping("/deletePostById")
    public PostResponse deletePostById(@RequestParam String postId){
        PostResponse res=new PostResponse();
        try {
            int post_id=Integer.parseInt(postId);
            if(postService.delPost(post_id)){
            }else {
                res.setResultCode(ResultCode.db_opterror.getCode());
                res.setResultMessage(ResultCode.db_opterror.getMessage());
            }
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.setResultCode(ResultCode.data_parse_error.getCode());
            res.setResultMessage(ResultCode.data_parse_error.getMessage());
            return res;
        }
    }
    @RequestMapping("/updatePost")
    public PostResponse updatepost(Post post){
        PostResponse res=new PostResponse();
        if(!postService.updatepost(post)){
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
}
