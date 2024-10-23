package com.microsoft.springMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/12
 */
@Configuration
@ComponentScan({"com.microsoft.springMVC.service", "com.microsoft.springMVC.dao"})
// 也可以排除 Controller
// @ComponentScan(value = "com.micorsoft.springMVC", exludeFileters = @ComponentScan.Fileter(type = FilterType.ANNOTATION, classes = Controller.class))
public class SpringConfig {
}
