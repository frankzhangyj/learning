package com.microsoft.springMVC.config;

import com.microsoft.springMVC.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description 用于注册拦截器 也可以直接在SpringMVCConfig中进行注册 但是侵入性较强 不符合IOC理念
 * @Author frank
 * @Date 2024/10/13
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    ProjectInterceptor projectInterceptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/user2")
    }
}
