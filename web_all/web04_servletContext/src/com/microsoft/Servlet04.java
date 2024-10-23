package com.microsoft;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

// 通过HttpServletRequest对象获得请求中的键值对(get方式也有请求体 但是键值放在请求头中key=value)(post方式键值对在请求体中)
@WebServlet("/servlet04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
         // 获得所有键值对
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            String[] parameterValues = req.getParameterValues(s);
            if (parameterValues.length > 1) {
                System.out.println(s + Arrays.toString(parameterValues));
            } else {
                System.out.println(s + parameterValues[0]);
            }
        }
        // 通过得到键值对的hashMap进而得到所有键值对
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            if (value.length > 1) {
                System.out.println(key + Arrays.toString(value));
            } else {
                System.out.println(key + value[0]);
            }
        }

        // 得到Servlet04的映射路径
        System.out.println(req.getServletPath());
        // 通过req.getReader() 得到JSON串
        // 通过req.getOutPutStream() 得到文件流
    }
}
