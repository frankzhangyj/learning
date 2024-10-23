package com.microsoft.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * filter作用于在客户端请求服务器资源servlet之间 可以对request作出过滤 并且对返回的response进行修改
 * 需要配置web.xml相关信息 类似servlet
 * 声明周期类似servlet 但是不能配置init()方法调用的顺序 (第一次请求时调用 还是初始化时调用)
 */
public class LoggingFilter implements Filter {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        String time = dateFormat.format(new Date());
        String beforeLogging = requestURI + "在" + time + "被请求了";
        System.out.println(beforeLogging);

        long t1 = System.currentTimeMillis();
        // 放行请求
        filterChain.doFilter(request, response);
        long t2 = System.currentTimeMillis();
        String afterLogging = requestURI + "在" + time + "的请求耗时: " + (t2 - t1) + "毫秒";

        System.out.println(afterLogging);
    }
}
