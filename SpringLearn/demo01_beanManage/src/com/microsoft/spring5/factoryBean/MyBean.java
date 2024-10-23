package com.microsoft.spring5.factoryBean;

import com.microsoft.spring5.User;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<User> {

    // 改变实际得到的对象类型
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setUsername("fuck");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
