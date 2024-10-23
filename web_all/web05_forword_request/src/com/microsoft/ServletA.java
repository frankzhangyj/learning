package com.microsoft;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String money = req.getParameter("money");
        req.setAttribute("reqkey", "reqvalue");
        // 请求转发是tomcat内部进行转发

        // 填写相对路径 不能访问项目以外的资源
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
        // 转发到 WEB-INF 路径下的唯一方法
        RequestDispatcher r0equestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");

        r0equestDispatcher.forward(req, resp);
    }
}
