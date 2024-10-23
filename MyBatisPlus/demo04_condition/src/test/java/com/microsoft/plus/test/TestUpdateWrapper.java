package com.microsoft.plus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.microsoft.plus.mapper.UserMapper;
import com.microsoft.plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@SpringBootTest
public class TestUpdateWrapper {
    @Autowired
    private UserMapper userMapper;
    // queryWrapper只能修改不为null的字段 并且需要手动创建一个实体
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
    // updateWrapper可以通过set方法设置一个任意值
    @Test
    public void testQuick2(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //将id = 3 的email设置为null, age = 18
        updateWrapper.eq("id",3)
                .set("email",null)  // set 指定列和结果
                .set("age",18);
        //如果使用updateWrapper 实体对象写null即可!
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result = " + result);

    }
}
