package com.microsoft.aop.annoAOP;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testAnnoAOP() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Calculate calculate = context.getBean("calculate", Calculate.class);
        calculate.add();
    }
}
