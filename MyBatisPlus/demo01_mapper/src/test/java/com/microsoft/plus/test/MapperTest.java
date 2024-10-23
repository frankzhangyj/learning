package com.microsoft.plus.test;

import com.microsoft.plus.MainApplication;
import com.microsoft.plus.mapper.UserMapper;
import com.microsoft.plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01() {
        User u = new User();
        u.setName("frank");
        u.setAge(19);
        u.setEmail("asdasfd");
        int row = userMapper.insert(u);
    }

    @Test
    public void test02() {
        //int delete = userMapper.deleteById(1848286394195705857L);
        Map<String, Object> map = new HashMap<>();
        map.put("age", 19);
        userMapper.deleteByMap(map);
    }

    @Test
    public void test03() {
        User u = new User();
        u.setId(1L);
        u.setName("frank");
        userMapper.updateById(u);

        // userMapper.update(u, null) 修改全部除了u中为null的
    }

    @Test
    public void test04() {
        List<Long> ul = new ArrayList<>();
        ul.add(1L);
        ul.add(2L);
        ul.add(3L);
        List<User> users = userMapper.selectBatchIds(ul);
        System.out.println(users);
    }
}




