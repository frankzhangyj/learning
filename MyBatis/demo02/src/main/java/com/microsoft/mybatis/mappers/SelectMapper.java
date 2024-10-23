package com.microsoft.mybatis.mappers;

import com.microsoft.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/14
 */
public interface SelectMapper {
    Map<String, Object> findUserToMap(@Param("id") int id);

    @MapKey("id")
    Map<String, Object> findALLUserToMap();

    List<User> getUserByLike(@Param("username") String username);

    int deleteMore(@Param("ids") String ids);

    void insertUser(User user);
}
