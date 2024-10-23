package com.microsoft.topNews.service.impl;

import com.microsoft.topNews.dao.NewsUserDao;
import com.microsoft.topNews.dao.impl.NewsUserDaoImpl;
import com.microsoft.topNews.pojo.NewsUser;
import com.microsoft.topNews.service.NewsUserService;
import com.microsoft.topNews.util.MD5Util;

public class NewsUserServiceImpl implements NewsUserService {
    NewsUserDao newsUserDao = new NewsUserDaoImpl();
    @Override
    public NewsUser findByUserName(String username) {
        return newsUserDao.findByUserName(username);
    }

    @Override
    public NewsUser findByUid(Integer uid) {
        return newsUserDao.findByUid(uid);
    }

    @Override
    public Integer registUser(NewsUser newsUser) {
        // 密码明文转密文
        newsUser.setUserPwd(MD5Util.encrypt(newsUser.getUserPwd()));
        // 存入数据库
        return newsUserDao.insertNewsUser(newsUser);
    }
}
