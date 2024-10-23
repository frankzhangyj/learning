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
public class OptimiseTest {
    @Autowired
    private UserMapper userMapper;
    //演示乐观锁生效场景 通过控制版本号 对数据进行操作时先对比版本号是否一致
    @Test
    public void testQuick7(){
        //步骤1: 先查询,在更新 获取version数据
        //同时查询两条,但是version唯一,最后更新的失败
        User user  = userMapper.selectById(5);
        User user1  = userMapper.selectById(5);

        user.setAge(20);
        user1.setAge(30);

        userMapper.updateById(user);
        //乐观锁生效,失败!
        userMapper.updateById(user1);
    }

}
