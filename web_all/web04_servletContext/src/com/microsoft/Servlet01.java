package com.microsoft;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------config-------------------");
        ServletConfig servletConfig = getServletConfig();
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String s = initParameterNames.nextElement();
            System.out.println(servletConfig.getInitParameter(s));
        }

        System.out.println("------------context------------------");
        ServletContext servletContext = getServletContext();
        ServletContext servletContext1 = req.getServletContext();
        ServletContext servletContext2 = servletConfig.getServletContext();

        Enumeration<String> initParameterNames1 = servletContext.getInitParameterNames();
        while (initParameterNames1.hasMoreElements()) {
            String s = initParameterNames1.nextElement();
            System.out.println(servletContext.getInitParameter(s));
        }
        // 获取域对象中的属性
        String jack = (String) servletContext.getAttribute("jack");
        System.out.println(jack);
    }
}
