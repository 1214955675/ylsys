package com.bs.sys.common;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wwj
 * 2019/4/3 17:27
 */
public class CommonsMultipartResolverforUeditor extends CommonsMultipartResolver {

    @Override
    public boolean isMultipart(HttpServletRequest request){
        String url=request.getRequestURI();
//        if(url!=null||url.contains("/ueditor")){
        if(url.contains("/ueditor")){
            return false;
        }else{
            return true;
        }
    }
}
