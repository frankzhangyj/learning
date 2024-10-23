package com.microsoft.spring5.service;

import com.microsoft.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 注解创建bean 共四个注解
 * @Component 该注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。  使用时只需将该注解标注在相应类上即可。
 * @Repository 该注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
 * @Service 该注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
 * @Controller 该注解通常作用在控制层（如SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
 */
@Service
public class UserService {
    @Value("frank") // 注入普通类型属性 相当于bean中的property属性
    private String username;
    @Autowired // 根据类型自动注入bean 相当于bean中的autowired的byType
    @Qualifier("userDaoImpl1") // 根据名称注入bean 可以联合Autowired  相当于byName
    private UserDao userDao;

    @Resource(name = "userDaoImpl1") // resource注解不是spring框架中的 可以选择根据类型或者名称注入
    private UserDao userDao2;
    public void add() {
        System.out.println("service...." + username);
        userDao.add();
    }

}
