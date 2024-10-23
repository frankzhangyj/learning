package com.microsoft.spring5.test;

import com.microsoft.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUser {

    @Test
    public void test01() {
        // 加载spring配置文件 也可以使用BeanFactory
        // BeanFactory 是spring中ioc基本接口 在哪里调用getBean 哪里创建对象
        // ApplicationContext 是BeanFactory的子接口 在读取xml配置文件时就会创建所有对象
        // IOC底层就是一个工厂模式 + 反射 + xml解析 将耦合度降低
        // 创建对象时默认调用无参构造函数
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");

        // 获取配置创建的对象
        User user = applicationContext.getBean("user", User.class);

        System.out.println(user);
        user.initTest();
    }
}
