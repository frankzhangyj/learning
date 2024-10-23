package com.microsoft;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1执行");
        // 响应重定向是服务端通过302响应码和路径,告诉客户端自己去找其他资源,是在服务端提示下的,客户端的行为

        // 相当于设置状态码302 并且设置header中location为servlet2
        //resp.sendRedirect("servlet2");

        // 不可以重定向到WEB—INF 因为相当于第二次请求时访问WEB-INF 但是这个文件是受保护的不能直接访问到
        //resp.sendRedirect("WEB-INF/b.html");

        // 可以重定向到项目外部资源
        resp.sendRedirect("https://www.baidu.com");
    }
}
