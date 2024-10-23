package com.microsoft;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet02")
public class Servlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        // 获得项目部署的真实磁盘路径(项目的部署磁盘路径)
        String realPath = servletContext.getRealPath("upload");
        // 获得项目访问路径(可以替换 就是设置tomcat时的项目访问路径 上下文路径)
        String contextPath = servletContext.getContextPath();
        System.out.println(realPath);
        System.out.println(contextPath);
    }
}
