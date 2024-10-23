package com.microsoft.mybatis.mappers;

import com.microsoft.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/14
 */
public interface ParamMapper {
    User findUser(int id);

    // 推荐使用注解
    User checkLogin(@Param("id") int id, @Param("password") String password);

    // 对象直接调用属性
    int insertUser(User user);

    User checkLoginByMap(Map<String, Object> map);
}
