package com.microsoft.spring5.IOCImpl.dao.daoImpl;

import com.microsoft.spring5.IOCImpl.anno.Bean;
import com.microsoft.spring5.IOCImpl.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("dao add......");
    }
}
