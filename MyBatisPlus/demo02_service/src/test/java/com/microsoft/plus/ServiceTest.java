package com.microsoft.plus;

import com.microsoft.plus.pojo.User;
import com.microsoft.plus.service.UserService;
import com.microsoft.plus.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testSave() {
        User u = new User();
        u.setName("li");
        u.setAge(21);
        u.setEmail("asdf");

        User u1 = new User();
        u1.setName("zhang");
        u1.setAge(23);
        u1.setEmail("asdf");

        User u2 = new User();
        u2.setName("zhao");
        u2.setAge(31);
        u2.setEmail("zcv");

        List<User> userList = new ArrayList<>();

        userList.add(u);
        userList.add(u1);
        userList.add(u2);

        userService.saveBatch(userList);
    }

    @Test
    public void testSaveOrUpdate() {
        User u = new User();
        u.setName("zhangsan");
        u.setAge(22);
        u.setEmail("asdfzxvc");
        // 如果id为空 那么为插入
        userService.saveOrUpdate(u);
        // 如果id不为空 那么为更新
    }

    @Test
    public void testRemove() {
        boolean b = userService.removeById(1848292283921223681L);
    }

    @Test
    public void testGetList() {
        User byId = userService.getById(1);
        // 条件为null 查询全部
        List<User> list = userService.list(null);
    }

}
