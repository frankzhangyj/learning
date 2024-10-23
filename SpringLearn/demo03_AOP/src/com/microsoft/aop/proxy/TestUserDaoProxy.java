package com.microsoft.aop.proxy;

import com.microsoft.aop.dao.UserDao;
import com.microsoft.aop.dao.daoImpl.UserDaoImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * 匿名内部类
 */
public class TestUserDaoProxy {
    @Test
    public void testProxy() {
        Class[] classes = {UserDao.class};
        UserDao userDao = new UserDaoImpl();
        // 通过jdk的Proxy类创建一个代理对象 其中InvocationHandler单独创建了一个类 也可以使用匿名内部类
        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(TestUserDaoProxy.class.getClassLoader(), classes, new UserDaoProxy(userDao));
        userDaoProxy.add();
    }
}
