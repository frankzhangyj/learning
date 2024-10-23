package com.microsoft.spring5.test;

import com.microsoft.spring5.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    // setter 属性注入
    @org.junit.Test
    public void testSet() {
        ApplicationContext userContext = new ClassPathXmlApplicationContext("bean1.xml");

        User user = userContext.getBean("user", User.class);

        System.out.println(user.toString());
    }

    // constructor arg 属性注入
    @org.junit.Test
    public void testConstruct() {
        ApplicationContext orderContext = new ClassPathXmlApplicationContext("bean1.xml");

        Orders order = orderContext.getBean("orders", Orders.class);

        System.out.println(order.toString());
    }

    // 外部bean注入
    @org.junit.Test
    public void testOuter() {
        ApplicationContext outerContext = new ClassPathXmlApplicationContext("bean2.xml");

        Outer outer = outerContext.getBean("outer", Outer.class);

        System.out.println(outer);
    }

    // 内部bean注入
    @org.junit.Test
    public void testInner() {
        ApplicationContext outerContext = new ClassPathXmlApplicationContext("bean2.xml");

        Outer1 outer = outerContext.getBean("outer1", Outer1.class);

        System.out.println(outer);
    }

    @org.junit.Test
    public void testOuter1() {
        ApplicationContext outerContext = new ClassPathXmlApplicationContext("bean2.xml");

        Outer2 outer = outerContext.getBean("outer2", Outer2.class);

        System.out.println(outer);
    }
}
