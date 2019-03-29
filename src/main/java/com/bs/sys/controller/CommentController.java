package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.request.CommentReq;
import com.bs.sys.common.response.CommentResponse;
import com.bs.sys.entity.Comment;
import com.bs.sys.service.impl.CommentServiceImpl;
import com.bs.sys.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * @author wwj
 * 2019/3/29 10:26
 */
@Controller
@RequestMapping("/comment")
@ResponseBody
public class CommentController {
    @Resource
    CommentServiceImpl commentService;
    @Resource
    UserServiceImpl userService;
    @RequestMapping("/addComment")
    public CommentResponse addcomment(CommentReq commentReq){
        CommentResponse res=new CommentResponse();
        if(commentReq.getFromUserId()!=null){
            commentReq.setFromUserImg(userService.findbyid(commentReq.getFromUserId()).getUserImg());
        }
        Long time=System.currentTimeMillis();
        if(commentService.addcomment(commentReq)<=0){
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/getCommentsByPost")
    public CommentResponse getcomments(int PostId){
        CommentResponse res=new CommentResponse();
        List<Comment> list=commentService.getcommentsbypostid(PostId);
        if(list==null){
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }else {
            res.setCommentList(list);
        }
        return res;
    }
}
