package com.microsoft.boot3.config;

import com.microsoft.boot3.intercepter.WebIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description webMVC配置类 配置拦截器 不用@EnableWebMvcConfig 因为springboot已经自动配置了webmvc的相关操作
 * @Author frank
 * @Date 2024/10/20
 */
@Configuration
public class WebMvcConfiguer implements WebMvcConfigurer {
    @Autowired
    private WebIntercepter webIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webIntercepter);
    }
}
