package com.microsoft.spring5.test;

import com.microsoft.spring5.config.SpringConfig;
import com.microsoft.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    @Test
    public void test() {
        ApplicationContext userContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = userContext.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 全注解开发 后面用springBoot
     */
    @Test
    public void test1() {
        ApplicationContext userContext = new AnnotationConfigApplicationContext(SpringConfig.class); // 用注解类解析
        UserService userService = userContext.getBean("userService", UserService.class);
        userService.add();
    }
}
