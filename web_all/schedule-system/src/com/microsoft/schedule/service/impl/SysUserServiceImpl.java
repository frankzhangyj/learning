package com.microsoft.schedule.service.impl;

import com.microsoft.schedule.dao.SysUserDao;
import com.microsoft.schedule.dao.impl.SysUserDaoImpl;
import com.microsoft.schedule.pojo.SysUser;
import com.microsoft.schedule.service.SysUserService;
import com.microsoft.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao sysUserDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        String pwd = sysUser.getUserPwd();
        String encrypt = MD5Util.encrypt(pwd);
        sysUser.setUserPwd(encrypt);

        int rows = sysUserDao.addSysUser(sysUser);
        return rows;
    }

    @Override
    public SysUser findByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }
}
