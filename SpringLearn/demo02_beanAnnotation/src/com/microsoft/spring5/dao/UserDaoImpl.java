package com.microsoft.spring5.dao;

import org.springframework.stereotype.Repository;

@Repository("userDaoImpl1")
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("add .....");
    }
}
