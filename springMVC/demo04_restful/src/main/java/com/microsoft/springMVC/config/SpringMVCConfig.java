package com.microsoft.springMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Description 用于开启注解扫描 加载bean
 * @Author frank
 * @Date 2024/10/12
 */
@Configuration
@ComponentScan("com.microsoft.springMVC.controller")
@EnableWebMvc
public class SpringMVCConfig {

}
