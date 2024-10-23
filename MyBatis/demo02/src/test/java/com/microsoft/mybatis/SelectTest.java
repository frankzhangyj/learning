package com.microsoft.mybatis;

import com.microsoft.mybatis.mappers.SelectMapper;
import com.microsoft.mybatis.pojo.User;
import com.microsoft.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/14
 */
public class SelectTest {
    /**
     * 查询出的数据将字段名作为键 将值作为值
     */
    @Test
    public void testSelect() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMap = mapper.findUserToMap(3);
        System.out.println(userToMap);
    }

    /**
     * 将id作为键将剩下字段和值作为值的map
     * 也可以将返回类型设置为map类型的list集合
     */
    @Test
    public void testALLSelect() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMap = mapper.findALLUserToMap();
        System.out.println(userToMap);
    }

    //测试类
    @Test
    public void insertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = new User(null, "ton", "123", 23, "男", "123@321.com");
        mapper.insertUser(user);
        System.out.println(user);
        //输出：user{id=10, username='ton', password='123', age=23, sex='男', email='123@321.com'}，自增主键存放到了user的id属性中
    }
}
