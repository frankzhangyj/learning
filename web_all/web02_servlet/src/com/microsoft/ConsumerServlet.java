package com.microsoft;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 添加注解可以省去在xml文件中添加class和url-pattern的映射
@WebServlet(value = "/servlet2", loadOnStartup = 6)
public class ConsumerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("fuck");
    }
}
