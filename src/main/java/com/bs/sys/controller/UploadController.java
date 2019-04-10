package com.bs.sys.controller;

import com.baidu.ueditor.ActionEnter;
import com.bs.sys.service.UploadService;
import com.bs.sys.service.impl.UploadServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author wwj
 * 2019/4/2 14:22
 */
@Controller
@RequestMapping("/wangeditor")
public class UploadController {
    @Resource
    UploadServiceImpl uploadService;
    @RequestMapping("/upload")
    public void config(HttpServletRequest request,@RequestParam("img") List<MultipartFile> list) {
        //这里是我在web中定义的两个初始化属性，保存目录的绝对路径和相对路径，你们可以自定义
        String imgUploadAbsolutePath = request.getSession().getServletContext().getInitParameter("imgUploadAbsolutePath");
        String imgUploadRelativePath = request.getSession().getServletContext().getInitParameter("imgUploadRelativePath");
        //服务曾处理数据，
        Boolean imgResult= uploadService.upLoadEditorImg(list, imgUploadAbsolutePath,
                imgUploadRelativePath);
//        return imgResult;
    }

}