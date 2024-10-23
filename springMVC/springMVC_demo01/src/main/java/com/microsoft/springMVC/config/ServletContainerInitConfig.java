package com.microsoft.springMVC.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @Description springMVC Container配置类 用于加载spring的配置
 *              AbstractDispatcherServletInitializer初始化springMVC容器抽象类
 * @Author frank
 * @Date 2024/10/12
 */
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {

    /**
     * 加载springMVC容器配置 将SpringMVC对应的bean放入容器
     * @return
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMVCConfig.class);
        return context;
    }

    /**
     * 设置哪些请求需要springMVC处理
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 加载spring容器配置非SpringMVC的bean
     * @return
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
