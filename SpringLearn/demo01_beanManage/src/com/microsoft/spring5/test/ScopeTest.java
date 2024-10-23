package com.microsoft.spring5.test;

import com.microsoft.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    /**
     * bean作用域共4个
     * 常用为prototype 和 singleton
     * prototype 可以创建多个实例 在getBean时创建
     * singleton 只能创建同一个实例 在xml解析时创建
     */
    @Test
    public void testScope() {
        ApplicationContext userContext = new ClassPathXmlApplicationContext("bean5.xml");
        User user1 = userContext.getBean("user", User.class);
        User user2 = userContext.getBean("user", User.class);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
