package com.microsoft;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet-api.jar: jdk中不包含这个包 在tomcat中 在编译时需要添加tomcat依赖
 *                   在打包构建运行后 通过tomcat服务软件 可以自动的将这个包引入
 * contentType: 请求响应头中的属性值 官方名称为MIME类型 根据资源后缀名 tomcat在conf/web.xml文件中找到对应文件的MIME类型
 */
public class UserServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String info = "No";
        if ("frank".equals(username)) {
            info = "<h1>Yes</h1>";
        }
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(info);
    }
}