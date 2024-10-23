package com.microsoft.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * cookie用于在客户端保存一些应用数据 一般不存储一些敏感或者影响安全的数据
 *
 */
@WebServlet("/servlet01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("c1", "c1message");
        Cookie cookie1 = new Cookie("c2", "c2message");
        // 设置cookie的时效时间单位秒
        cookie1.setMaxAge(60);
        // 设置cookie的提交路径 访问这个路径时携带保存的cookie
        cookie1.setPath("/web07_cookie_session/servlet02");
        resp.addCookie(cookie);
        resp.addCookie(cookie1);

    }
}
