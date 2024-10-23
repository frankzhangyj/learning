package com.microsoft.ssm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
public class SpringIocInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 加载服务层 和 持久层 bean 配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ServiceJavaConfig.class, MapperJavaConfigNew.class, DataSourceJavaConfig.class};
    }
    // 加载控制层 bean 配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebJavaConfig.class};
    }
    // 配置资源映射根路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
