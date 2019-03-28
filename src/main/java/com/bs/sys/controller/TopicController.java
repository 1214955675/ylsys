package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.request.TopicReq;
import com.bs.sys.common.response.TopicResponse;
import com.bs.sys.entity.Topic;
import com.bs.sys.service.TopicServiceInf;
import com.bs.sys.service.impl.TopicServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wwj
 * 2019/3/28 12:57
 */
@RequestMapping("/topic")
@Controller
@ResponseBody
public class TopicController {
    @Resource
    TopicServiceImpl topicService;
    @RequestMapping("/addTopic")
    public TopicResponse addtopic(TopicReq topicReq){
        TopicResponse res=new TopicResponse();
        try {int newid=topicService.addTopic(topicReq);
            Topic restopic=new Topic();
            restopic.setId(newid);
            res.setTopic(restopic);
        }catch (Exception e){
            e.printStackTrace();
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/delTopic")
    public TopicResponse deltopic(TopicReq topicReq){
        TopicResponse res=new TopicResponse();
        if(topicService.delTopicbyid(topicReq.getId())){
            return res;
        }else{
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/getalltopic")
    public TopicResponse getalltopic(TopicReq topicReq, @RequestParam(value = "page",defaultValue = "1")String page,
                                     @RequestParam(value = "limit",defaultValue = "10")String limit){
        TopicResponse res=new TopicResponse();
        int pagenum=0;
        int limitnum=0;
        try {
             pagenum=Integer.parseInt(page);
             limitnum=Integer.parseInt(limit);
        }catch (NumberFormatException e){
            res.setResultCode(ResultCode.data_parse_error.getCode());
            res.setResultMessage(ResultCode.data_parse_error.getMessage());
            return res;
        }
        res.setTopicList(topicService.getalltopic(pagenum, limitnum));
        return res;
    }
    @RequestMapping("/updateTopic")
    public TopicResponse updatetopic(TopicReq topicReq){
        TopicResponse res=new TopicResponse();
        if(topicService.updatetopicbyid(topicReq)){
            return res;
        }else {
            res.setResultMessage(ResultCode.db_opterror.getMessage());
            res.setResultCode(ResultCode.db_opterror.getCode());
        }
        return res;
    }
}
