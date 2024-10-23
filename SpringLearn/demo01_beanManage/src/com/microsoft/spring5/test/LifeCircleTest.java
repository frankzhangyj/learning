package com.microsoft.spring5.test;

import com.microsoft.spring5.lifeCircle.LifeCircle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCircleTest {
    @Test
    public void test() {
        ApplicationContext lifeContext = new ClassPathXmlApplicationContext("bean6.xml");
        LifeCircle lifeCircle = lifeContext.getBean("lifeCircle", LifeCircle.class);
        System.out.println("4 执行了bean");
        ((ClassPathXmlApplicationContext)lifeContext).close();
    }
}
