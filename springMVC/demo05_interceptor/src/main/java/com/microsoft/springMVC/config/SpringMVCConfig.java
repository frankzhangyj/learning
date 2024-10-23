package com.microsoft.springMVC.config;

import com.microsoft.springMVC.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 用于开启注解扫描 加载bean
 * @Author frank
 * @Date 2024/10/12
 */
@Configuration
@ComponentScan({"com.microsoft.springMVC.controller", "com.microsoft.springMVC.config"})
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {
    @Autowired
    ProjectInterceptor projectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/users2");
    }
}
