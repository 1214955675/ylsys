package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.request.TopicReq;
import com.bs.sys.common.response.TopicResponse;
import com.bs.sys.entity.Listbysql;
import com.bs.sys.entity.Topic;
import com.bs.sys.service.impl.TopicServiceImpl;
import com.bs.sys.service.impl.userTasteServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    @Resource
    userTasteServiceImpl userTasteService;
    @RequestMapping("/addTopic")
    public TopicResponse addtopic(HttpServletRequest request,TopicReq topicReq,
                                  @RequestParam(value = "file",required = false)CommonsMultipartFile file) throws IOException {
        TopicResponse res=new TopicResponse();
        if(file!=null){
            // 获取项目路径
            String realPath = request.getServletContext()
                    .getRealPath("");
            String onurl="";
            InputStream inputStream =file.getInputStream();
            String contextPath = request.getContextPath();
            // 服务器根目录的路径
//                String path = realPath.replace(contextPath.substring(1), "");
//                String path=realPath.substring(0,realPath.lastIndexOf('/'));
            // 根目录下新建文件夹upload，存放上传图片
            String uploadPath = realPath + "upload";
            // 获取文件名称
            String filename = file.getOriginalFilename();
            // 将文件上传的服务器根目录下的upload文件夹
            File file1 = new File(uploadPath, filename);
            FileUtils.copyInputStreamToFile(inputStream, file1);
            // 返回图片访问路径
            String url = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/upload/" + filename;
            onurl=url;

            topicReq.setImgUrl(onurl);
        }

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
                                     @RequestParam(value = "limit",defaultValue = "10")String limit,@RequestParam(value = "userId",required = false)String userId){
        TopicResponse res=new TopicResponse();
        int pagenum=0;
        int limitnum=0;
        List<Topic> topiclist=new ArrayList<>();
        List<Listbysql> listsql=new ArrayList<>();
        try {
             pagenum=Integer.parseInt(page);
             limitnum=Integer.parseInt(limit);
            topiclist=topicService.getalltopic(pagenum, limitnum);
            if(userId!=null){
                 int userid_int=Integer.parseInt(userId);
                 listsql=userTasteService.getbyuserid(userid_int);
                 for(int i=0;i<listsql.size();i++){
                     for(int j=0;j<topiclist.size();j++){
                         if(listsql.get(i).getObjectid()==topiclist.get(j).getId()){
                             topiclist.get(j).setTasteCountForPerson(listsql.get(i).getCount());
                             break;
                         }
                     }
                 }
                 Collections.sort(topiclist);
             }
        }catch (NumberFormatException e){
            res.setResultCode(ResultCode.data_parse_error.getCode());
            res.setResultMessage(ResultCode.data_parse_error.getMessage());
            return res;
        }
        res.setTopicList(topiclist);
        return res;
    }
    @RequestMapping("/updateTopic")
    public TopicResponse updatetopic(HttpServletRequest request,TopicReq topicReq,
                                     @RequestParam(value = "file",required = false)CommonsMultipartFile file) throws IOException {
        TopicResponse res=new TopicResponse();
        if(file!=null){
            // 获取项目路径
            String realPath = request.getServletContext()
                    .getRealPath("");
            String onurl="";
            InputStream inputStream =file.getInputStream();
            String contextPath = request.getContextPath();
            // 服务器根目录的路径
//                String path = realPath.replace(contextPath.substring(1), "");
//                String path=realPath.substring(0,realPath.lastIndexOf('/'));
            // 根目录下新建文件夹upload，存放上传图片
            String uploadPath = realPath + "upload";
            // 获取文件名称
            String filename = file.getOriginalFilename();
            // 将文件上传的服务器根目录下的upload文件夹
            File file1 = new File(uploadPath, filename);
            FileUtils.copyInputStreamToFile(inputStream, file1);
            // 返回图片访问路径
            String url = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/upload/" + filename;
            onurl=url;

            topicReq.setImgUrl(onurl);
        }
        if(topicService.updatetopicbyid(topicReq)){
            return res;
        }else {
            res.setResultMessage(ResultCode.db_opterror.getMessage());
            res.setResultCode(ResultCode.db_opterror.getCode());
        }
        return res;
    }
}
