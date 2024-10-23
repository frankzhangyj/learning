import com.microsoft.myBatis.mapper.UserMapper;
import com.microsoft.myBatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/14
 */
public class UserMapperTest {
    @Test
    public void testInsert() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        // sqlSession默认不自动提交事务
        SqlSession sqlSession = build.openSession(true);
        // 获取mapper接口对象 底层使用代理模式创建对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.insertUser();
        // 如果在openSession没有设置true 需要手动提交事务
        // sqlSession.commit();
        System.out.println(result);
    }

    @Test
    public void testUpdate() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser();
        System.out.println(result);
    }

    @Test
    public void testDelete() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUser();
        System.out.println(result);
    }

    @Test
    public void testSeletUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User result = mapper.findUser();
        System.out.println(result);
    }

    @Test
    public void testSeletAllUsers() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> result = mapper.findAllUsers();
        result.forEach(System.out::println);
    }
}
