package com.microsoft.schedule.dao;

import com.microsoft.schedule.pojo.SysUser;

public interface SysUserDao {
    int addSysUser(SysUser sysUser);


    SysUser findByUsername(String username);
}
