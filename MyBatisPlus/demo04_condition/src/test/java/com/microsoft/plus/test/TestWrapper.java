package com.microsoft.plus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microsoft.plus.mapper.UserMapper;
import com.microsoft.plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@SpringBootTest
public class TestWrapper {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01() {
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (username LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test03(){
        //删除email为空的用户
        //DELETE FROM t_user WHERE (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        //条件构造器也可以构建删除语句的条件
        int result = userMapper.delete(queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test04() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE username LIKE ? AND age > ? OR email IS NULL)
        queryWrapper
                .like("username", "a")
                .gt("age", 20)
                .or()
                .isNull("email");
        User user = new User();
        user.setAge(18);
        user.setEmail("user@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test05() {
        //查询用户信息的username和age字段
        //SELECT username,age FROM t_user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("username", "age");
        //selectMaps()返回Map集合列表，通常配合select()使用，避免User对象中没有被查询到的列值为null
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void testQuick3(){

        String name = "root";
        int    age = 18;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //判断条件拼接
        //当name不为null拼接等于, age > 1 拼接等于判断
        //方案1: 手动判断
        if (!StringUtils.isBlank(name)){
            queryWrapper.eq("name",name);
        }
        if (age > 1){
            queryWrapper.eq("age",age);
        }

        //方案2: 拼接condition判断
        //每个条件拼接方法都condition参数,这是一个比较运算,为true追加当前条件!
        //eq(condition,列名,值)
        queryWrapper.eq(!StringUtils.isBlank(name),"name",name)
                .eq(age>1,"age",age);
    }
}
