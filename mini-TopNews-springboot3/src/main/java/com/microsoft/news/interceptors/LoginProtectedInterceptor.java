package com.microsoft.news.interceptors;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.news.utils.JwtHelper;
import com.microsoft.news.utils.Result;
import com.microsoft.news.utils.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/23
 */
@Component
public class LoginProtectedInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        boolean expiration = jwtHelper.isExpiration(token);

        if (StringUtils.isEmpty(token) || expiration) {
            Result<Object> result = Result.build(null, ResultCodeEnum.NOTLOGIN);
            ObjectMapper objectMapper = new ObjectMapper();
            String in = objectMapper.writeValueAsString(request);
            response.getWriter().print(in);
            return false;
        }

        return true;
    }
}
