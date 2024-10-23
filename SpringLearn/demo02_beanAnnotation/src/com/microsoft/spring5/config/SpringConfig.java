package com.microsoft.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 构造配置类代替xml配置信息
 */
@Configuration
@ComponentScan(basePackages = {"com.microsoft"}) // 相当于xml中的<context:component-scan base-package="com.microsoft"></context:component-scan>
public class SpringConfig {
}
