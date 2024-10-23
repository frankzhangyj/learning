package com.microsoft;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet03")
public class Servlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到协议
        String scheme = req.getScheme();
        // 协议与版本号
        String protocol = req.getProtocol();
        // 请求方式
        String method = req.getMethod();
        // URI 为资源在项目中的路径 /demo/test.html
        String requestURI = req.getRequestURI();
        // URL 为资源具体的路径 http://ip:port/demo/test.html
        StringBuffer requestURL = req.getRequestURL();
        // 本应用容器端口号(tomcat的端口号)
        int localPort = req.getLocalPort();
        // 客户端软件端口号(客户端软件的端口号)
        int remotePort = req.getRemotePort();
        // 客户端发送请求时的端口号(客户端如果通过代理访问服务器 那么服务器端口号就是请求代理时的端口号 不是服务器tomcat的端口号)
        int serverPort = req.getServerPort();


    }
}
