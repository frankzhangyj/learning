package com.microsoft;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

// servletConfig 是每个servlet中自定义的键值对
// servletContext 是所有servlet共用的键值对
@WebServlet(urlPatterns = "/servlet", initParams = {@WebInitParam(name = "fuck", value = "you")})
public class Servlet extends HttpServlet {
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

        // 通过servlet域对象ServletContext进行servlet之间的数据传递
        servletContext.setAttribute("jack", "adfasdfasddf");
    }
}
