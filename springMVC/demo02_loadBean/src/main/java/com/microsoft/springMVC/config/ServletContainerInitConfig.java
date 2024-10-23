package com.microsoft.springMVC.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @Description springMVC Container配置类 用于加载spring的配置
 *              AbstractDispatcherServletInitializer初始化springMVC容器抽象类
 * @Author frank
 * @Date 2024/10/12
 */
/*
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createServletApplicationContext() {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMVCConfig.class);
        return context;
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        return context;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
*/

/**
 * @Description springMVC Container配置类 用于加载spring的配置
 *  AbstractAnnotationConfigDispatcherServletInitializer 是 AbstractDispatcherServletInitializer 子类可以简化配置SpringMVC和Spring容器
 * @Author frank
 * @Date 2024/10/12
 */
public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 简化Spring对应bean加载
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 简化SpringMVC对应bean加载
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 设置一个过滤器处理post请求发送的请求体中的数据乱码问题
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("GBK");
        return new Filter[]{filter};
    }
}

