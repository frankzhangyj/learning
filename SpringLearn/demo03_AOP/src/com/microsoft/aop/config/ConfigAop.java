package com.microsoft.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类实现全注解AOP 不需要配置xml
 */
@Configuration
@ComponentScan(basePackages = {"com.microsoft"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
