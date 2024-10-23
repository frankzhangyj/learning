package com.microsoft.myBatis.mapper;

import com.microsoft.myBatis.pojo.User;

import java.util.List;

/**
 * @Description myBatis 面向接口编程 接口相当于dao类 通过xml映射文件操作sql
 *              一个mapper接口对应一个mapper映射xml文件
 *              一个标签id对应一个方法名
 * @Author frank
 * @Date 2024/10/14
 */
public interface UserMapper {
    int insertUser();

    int updateUser();

    int deleteUser();

    User findUser();

    List<User> findAllUsers();
}
