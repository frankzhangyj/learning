package com.microsoft.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql = "update account set money = money + ? where uid = ?";
        jdbcTemplate.update(sql, "100", 1);
    }

    @Override
    public void reduceMoney() {
        String sql = "update account set money = money - ? where uid = ?";
        jdbcTemplate.update(sql, "100", 2);
    }
}
