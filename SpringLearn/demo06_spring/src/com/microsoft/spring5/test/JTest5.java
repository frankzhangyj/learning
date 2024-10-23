package com.microsoft.spring5.test;

import com.microsoft.spring5.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 通过Spring注解简化JUnit5测试从IOC容器获取对象
 */
@ExtendWith(SpringExtension.class) // sping中自带JUnit5
@ContextConfiguration("classpath:bean1.xml") // 相当于原来context解析bean配置文件
// @SpringJUnitConfig(locations = "classpath:bean1.xml") 将上面两个注解整合
public class JTest5 {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test() {
        System.out.println(userService);
    }
}
