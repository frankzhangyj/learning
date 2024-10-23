package com.microsoft.schedule.test;

import com.microsoft.schedule.dao.BaseDao;
import com.microsoft.schedule.pojo.SysUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TestBaseDao {

    private static BaseDao baseDao;

    @BeforeEach
    public void initDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseDao() {
        String sql = "select count(1) from sys_user";
        Long rows = baseDao.baseQueryObject(long.class, sql);
        System.out.println(rows);

        sql = "select uid, username, user_pwd userPwd from sys_user";
        List<SysUser> rows1 = baseDao.baseQuery(SysUser.class, sql);
        rows1.forEach(System.out::println);

        sql = "insert into sys_user values(default, ?, ?)";
        int frank = baseDao.baseUpdate(sql, "fran", "123");
       System.out.println(frank);
    }

}
