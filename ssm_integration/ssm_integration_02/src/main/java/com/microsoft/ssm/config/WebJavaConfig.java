package com.microsoft.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Description springMVC配置 静态资源 拦截器 异常处理器
 * @Author frank
 * @Date 2024/10/16
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.microsoft.ssm.controller"})
public class WebJavaConfig implements WebMvcConfigurer {
    /**
     * 允许加载静态资源
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views", "jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor().excludePathPatterns();
    }
}
