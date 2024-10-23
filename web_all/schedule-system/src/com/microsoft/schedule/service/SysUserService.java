package com.microsoft.schedule.service;

import com.microsoft.schedule.pojo.SysUser;

public interface SysUserService {
    int regist(SysUser sysUser);

    SysUser findByUsername(String username);
}
