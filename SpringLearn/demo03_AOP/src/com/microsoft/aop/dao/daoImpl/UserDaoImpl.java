package com.microsoft.aop.dao.daoImpl;

import com.microsoft.aop.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDao add....");
    }

    @Override
    public void update() {
        System.out.println("UserDao update....");
    }
}
