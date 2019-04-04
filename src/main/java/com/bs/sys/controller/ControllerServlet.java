package com.bs.sys.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.baidu.ueditor.ActionEnter;
/**
 * @author wwj
 * 2019/4/2 11:16
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
// TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      )
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      )
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        String jsonFilePath = rootPath + "ueditor/utf8-jsp/ueditor.config.js";
        response.getWriter().write(new ActionEnter(request,jsonFilePath).exec());
    }


}
