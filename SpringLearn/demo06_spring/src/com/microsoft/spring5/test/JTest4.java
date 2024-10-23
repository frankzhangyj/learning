package com.microsoft.spring5.test;

import com.microsoft.spring5.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 通过Spring注解简化JUnit4测试从IOC容器获取对象
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean1.xml") // 相当于原来context解析bean配置文件
public class JTest4 {
    @Autowired // 直接注入IOC容器中的service对象
    private UserServiceImpl service;

    @Test
    public void test() {
        System.out.println(service);
    }
}




