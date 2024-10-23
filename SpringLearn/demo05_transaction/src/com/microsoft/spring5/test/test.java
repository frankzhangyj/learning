package com.microsoft.spring5.test;

//import com.microsoft.spring5.config.SpringConfig;
import com.microsoft.spring5.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void testAccount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
        // userServiceImpl.accountMoney();

        userServiceImpl.accountMoneyByAnno();
    }

    /**
     * 测试全注解实现事务
     */
/*    public void testAnno() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl usreService = context.getBean("usreService", UserServiceImpl.class);
        usreService.accountMoneyByAnno();
    }*/
}
