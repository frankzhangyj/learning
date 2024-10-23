package com.microsoft.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session
        HttpSession session = req.getSession();
        String jSessionId = session.getId();
        System.out.println(jSessionId);

        boolean aNew = session.isNew();
        System.out.println(aNew);

        String username = (String)session.getAttribute("username");
        System.out.println(username);
    }
}
