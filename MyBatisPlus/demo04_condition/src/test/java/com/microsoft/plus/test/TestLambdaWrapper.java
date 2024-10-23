package com.microsoft.plus.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.microsoft.plus.mapper.UserMapper;
import com.microsoft.plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
public class TestLambdaWrapper {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testLambda() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.eq(User::getName, "John")
                .ge(User::getAge, 18)
                .orderByDesc(User::getAge)
                .last("limit 10");
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
    }
}
