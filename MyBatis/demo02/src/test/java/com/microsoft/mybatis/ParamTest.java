package com.microsoft.mybatis;

import com.microsoft.mybatis.mappers.ParamMapper;
import com.microsoft.mybatis.pojo.User;
import com.microsoft.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/14
 */
public class ParamTest {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParamMapper mapper = sqlSession.getMapper(ParamMapper.class);
        // User user = mapper.findUser(3);
        // User user = mapper.checkLogin(3,"123456");
        // int row = mapper.insertUser(new User(null, "jack", "123456", 19, "男", "123@qq.com"));
        Map<String,Object> map = new HashMap<>();
        map.put("username","frank");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
}
