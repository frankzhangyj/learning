package com.microsoft.mybatis;

import com.microsoft.mybatis.mappers.EmpMapper;
import com.microsoft.mybatis.pojo.Emp;
import com.microsoft.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/15
 */
public class CacheTest {
    /**
     * 一级缓存是sqlsession级别 增删改会自动清除缓存
     */
    @Test
    public void testCache1() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession1.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(3);
        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        Emp empAndDept1 = mapper.getEmpAndDept(3);

        sqlSession1.clearCache();
    }

    /**
     * 二级缓存是sqlsessionFactory级别 同一个sqlsessionFactory构造的sqlsession共用缓存
     * 前提实体类必须序列化 需要手动提交或关闭Sqlsession才能进入二级缓存
     * 如果期间执行增删改 即会清空一级 还会清空二级
     */
    @Test
    public void testCache2() {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        SqlSession sqlSession1 = build.openSession(true);

        EmpMapper mapper = sqlSession1.getMapper(EmpMapper.class);
        EmpMapper mapper1 = sqlSession.getMapper(EmpMapper.class);

        Emp empAndDept = mapper.getEmpAndDept(3);
        sqlSession.commit();
        Emp empAndDept1 = mapper1.getEmpAndDept(3);
    }


}
