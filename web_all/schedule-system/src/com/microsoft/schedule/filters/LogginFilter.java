package com.microsoft.schedule.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter({"/schedule.html", "/schedule/*"})
public class LogginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        HttpSession session = req.getSession();
        Object sysUser = session.getAttribute("sysUser");

        if (sysUser == null) {
            resp.sendRedirect("/login.html");
        } else {
            chain.doFilter(request, response);
        }
    }
}
