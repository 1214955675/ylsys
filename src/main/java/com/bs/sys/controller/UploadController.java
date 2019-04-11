package com.bs.sys.controller;

import com.alibaba.fastjson.JSONArray;
import com.baidu.ueditor.ActionEnter;
import com.bs.sys.entity.ImgResultDto;
import com.bs.sys.service.UploadService;
import com.bs.sys.service.impl.UploadServiceImpl;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wwj
 * 2019/4/2 14:22
 */
@Controller
@RequestMapping("/wangeditor")
public class UploadController {
    @Resource
    UploadServiceImpl uploadService;
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Object config(HttpServletRequest request, @RequestParam("img") List<MultipartFile> list,
                          HttpServletResponse response) {
        //这里是我在web中定义的两个初始化属性，保存目录的绝对路径和相对路径，你们可以自定义
        Map<String,Object> map=new HashMap<String,Object>();
//        ImgResultDto object=new ImgResultDto();

        try {
            /*String imgUploadAbsolutePath = request.getServletContext().getInitParameter("imgUploadAbsolutePath");
            String imgUploadRelativePath = request.getServletContext().getInitParameter("imgUploadRelativePath");
            //服务曾处理数据，
            return uploadService.upLoadEditorImg(list, imgUploadAbsolutePath,
                    imgUploadRelativePath);*/
            // 获取项目路径
            String realPath = request.getServletContext()
                    .getRealPath("");
            String[] urls=new String[list.size()];
            String onurl="";
            for(int i=0;i<list.size();i++){
                InputStream inputStream = list.get(i).getInputStream();
                String contextPath = request.getContextPath();
                // 服务器根目录的路径
//                String path = realPath.replace(contextPath.substring(1), "");
//                String path=realPath.substring(0,realPath.lastIndexOf('/'));
                // 根目录下新建文件夹upload，存放上传图片
                String uploadPath = realPath + "upload";
                // 获取文件名称
                String filename = list.get(i).getOriginalFilename();
                // 将文件上传的服务器根目录下的upload文件夹
                File file = new File(uploadPath, filename);
                FileUtils.copyInputStreamToFile(inputStream, file);
                // 返回图片访问路径
                String url = request.getScheme() + "://" + request.getServerName()
                        + ":" + request.getServerPort() + "/upload/" + filename;
                urls[i]=url;
                onurl=url;
            }
//            response.setContentType("text/text;charset=utf-8");
//            PrintWriter out = response.getWriter();
////            out.print(JSONObject.valueToString(urls));  //返回url地址
//            out.print(onurl);  //返回url地址
//            out.flush();
//            out.close();
            map.put("errno", 0);
            map.put("data", urls);
            Object jo=JSONArray.toJSONString(map);
            return jo;

        }
        catch (Exception e) {
            //这里errno随便设置多少,只要不是0
            e.printStackTrace();
//            object.setErrno(500);
////            object.setData(new String[]{});
//            object.put("errno","200");
//            object.put("msg","服务器异常");
            return map;
        }

//        return imgResult;
    }
    @RequestMapping(value = "/getUploadImg",method = RequestMethod.GET)
    public void getuploadimg(String path,HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg"); // 设置返回内容格式
        path=new String(path.getBytes("ISO-8859-1"),"UTF-8");
        File file = new File("D:/opt/img/"+path);       //括号里参数为文件图片路径
        if(file.exists()){   //如果文件存在
            InputStream in = new FileInputStream("D:/opt/img/"+path);   //用该文件创建一个输入流
            OutputStream os = response.getOutputStream();  //创建输出流
            byte[] b = new byte[1024];
            while( in.read(b)!= -1){
                os.write(b);
            }
            in.close();
            os.flush();
            os.close();
        }

    }

}