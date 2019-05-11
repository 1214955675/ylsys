package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.response.MessageResponse;
import com.bs.sys.common.response.UserResponse;
import com.bs.sys.entity.Message;
import com.bs.sys.entity.User;
import com.bs.sys.service.impl.MessageServiceImpl;
import com.bs.sys.service.impl.UserServiceImpl;
import com.bs.sys.webSocket.WebSocketMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@Controller
@RequestMapping("/IM")
@ResponseBody
public class IMController {
    @Autowired
    MessageServiceImpl messageService;
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/getOnline")
    public HashMap<Integer,String> getonline(){
        return WebSocketMsg.idandnameMap;
    }
    @RequestMapping("/getAllWithYourChat")
    public UserResponse getAllWithYourChat(int userId){
        UserResponse res=new UserResponse();
        List<Integer> list=messageService.getyourchat(userId);
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        List<User> userlist=new ArrayList<>();
        User resuser=new User();
        for (int i=0;i<list.size();i++){
            User user=userService.findbyid(list.get(i));
            resuser.setId(list.get(i));
            resuser.setUserImg(user.getUserImg()==null?"":user.getUserImg());
            resuser.setUserName(user.getUserName());
            resuser.setNickName(user.getNickName()==null?"":user.getNickName());
            userlist.add(resuser);
        }
        res.setUserList(userlist);
        return res;
    }
    @RequestMapping("/getMsgByWho")
    public MessageResponse getMsg(@RequestParam String userId,@RequestParam String whoseId){
        MessageResponse res=new MessageResponse();
        HashMap<Integer, List<Message>> restrun=new HashMap<>();
        try {
            int userid_int=Integer.parseInt(userId);
            int whoid_int=Integer.parseInt(whoseId);
                //默认获取七天数据
                res.setMessageList(messageService.getmsgbywho(userid_int,whoid_int,System.currentTimeMillis()-1000*60*60*24*7));
//            else if(fromTime!=null&&toTime!=null){
//                long fromtimeint=(long)Integer.parseInt(fromTime);
//                long totimeint=(long)Integer.parseInt(toTime);
//                res.setMessageList(messageService.getmsgbytime(userid_int,fromtimeint,totimeint));
//            }
//            List<Message> needformat=res.getMessageList();
//            Set<Integer> allrelationid=new HashSet<>();
//            for(int i=0;i<needformat.size();i++){
//                allrelationid.add(needformat.get(i).getFromId());
//                allrelationid.add(needformat.get(i).getToId());
//            }
        }catch (Exception e){
            e.printStackTrace();
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/getMsgByWhoByTime")
    public MessageResponse getMsg(@RequestParam String userId,@RequestParam String whoseId,@RequestParam long fromTime,@RequestParam long toTime) {
        MessageResponse res=new MessageResponse();
        try {
            int userid_int=Integer.parseInt(userId);
            int whoid_int=Integer.parseInt(whoseId);
//            long fromtimeint=(long)Integer.parseInt(fromTime);
//            long totimeint=(long)Integer.parseInt(toTime);
            res.setMessageList(messageService.getmsgbywhotime(userid_int,whoid_int,fromTime,toTime));
        }catch (Exception e){
            e.printStackTrace();
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
}
