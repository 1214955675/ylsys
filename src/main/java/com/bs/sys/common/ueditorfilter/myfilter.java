package com.bs.sys.common.ueditorfilter;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author wwj
 * 2019/4/3 16:54
 */
public class myfilter extends StrutsPrepareAndExecuteFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getRequestURI();
        System.out.println(url);
        if (url.contains("/")) {
            System.out.println("使用自定义过滤器");
            chain.doFilter(req, res);
        }else{
            System.out.println("使用默认过滤器");
            super.doFilter(req, res, chain);
        }
    }
}
