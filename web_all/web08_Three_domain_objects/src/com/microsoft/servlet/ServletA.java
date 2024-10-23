package com.microsoft.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求域传递数据的范围是一次请求之内及请求转发
        req.setAttribute("request","request-message");
        //req.getRequestDispatcher("servletB").forward(req,resp);

        // 向会话域中放入数据 传递数据的范围是一次会话之内,可以跨多个请求
        HttpSession session = req.getSession();
        session.setAttribute("session","session-message");

        // 向应用域中放入数据 传递数据的范围是本应用之内,可以跨多个会话
        ServletContext application = getServletContext();
        application.setAttribute("application","application-message");
    }
}
