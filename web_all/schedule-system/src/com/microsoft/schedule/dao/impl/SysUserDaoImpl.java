package com.microsoft.schedule.dao.impl;

import com.microsoft.schedule.dao.BaseDao;
import com.microsoft.schedule.dao.SysUserDao;
import com.microsoft.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(default, ?, ?)";
        System.out.println(sysUser.getUsername() + " " + sysUser.getUserPwd());
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
    }


    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid,username, user_pwd userPwd from sys_user where username = ?";
        List<SysUser> userList = baseQuery(SysUser.class, sql, username);
        return null != userList && userList.size() > 0 ? userList.get(0) : null;
    }
}

