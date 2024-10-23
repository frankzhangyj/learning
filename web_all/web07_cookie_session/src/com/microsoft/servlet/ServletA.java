package com.microsoft.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * session用于将客户端数据存储在服务器上 客户端在发送请求时,都可以使用自己的session. 这样服务端就可以通过session来记录某个客户端的状态了
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        // 获取session对象 如果请求中有sessionId 那么根据id在服务器找到对应的session对象 如果没有这个对象 那么就创建新的session对象 将id以cookie形式放入response中
        // 如果没有sessionId 那么会重新创建一个session对象 将id以cookie形式放入response中
        HttpSession session = req.getSession();
        String jSessioinId = session.getId();
        System.out.println(jSessioinId);
        boolean isNew = session.isNew();
        System.out.println(isNew);
        // 可以设置多个属性
        session.setAttribute("username", username);
        // tomcat的web.xml中默认session存活时间为30分钟
        // 也可以设置时间
        session.setMaxInactiveInterval(60);
    }
}
