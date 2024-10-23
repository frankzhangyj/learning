package com.microsoft;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 对于完美解决项目路径中的上下文路径可能会发生改变的问题 可以直接将项目上下文设置为/ 之后所有的绝对路径直接/a/b 就可以
@WebServlet("/a/b/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA");

        // 响应重定向
        // 相对路径 http://ip/port/当前资源所在路径 + 设定的相对路径
//        resp.sendRedirect("../../servletB");

        // 绝对路径 http://ip/port/ + 设定的绝对路径
//        resp.sendRedirect("/web06/servletB");

        // 也可以动态在绝对路径中修改上下文路径
//        ServletContext servletContext = req.getServletContext();
//        String contextPath = servletContext.getContextPath();
//        resp.sendRedirect(contextPath + "/servletB");

        // 请求转发
        // 相对路径 http://ip/port/当前资源所在路径 + 设定的相对路径
//        req.getRequestDispatcher("../../servletB").forward(req, resp);

        // 绝对路径有区别 不需要加项目上下文路径
//        req.getRequestDispatcher("/serletB").forward(req, resp);
    }
}
