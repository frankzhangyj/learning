package com.microsoft.spring5.test;

import com.microsoft.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 工厂bean可以得到不是配置文件中定义的类
 */
public class FactoryTest {
    @Test
    public void testFac() {
        ApplicationContext facContext = new ClassPathXmlApplicationContext("bean4.xml");

        User user = facContext.getBean("myFactory", User.class);

        System.out.println(user);
    }
}
