package com.microsoft;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet05")
public class Servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setHeader("aaa", "bbb");
        String info = "<h1>fuck</h1>";
        resp.setContentLength(info.getBytes().length);
        PrintWriter writer = resp.getWriter();
        writer.write(info);
        // 向响应头放二进制数据流
        ServletOutputStream outputStream = resp.getOutputStream();
    }
}
