package com.microsoft.topNews.dao;

import com.microsoft.topNews.pojo.NewsUser;

public interface NewsUserDao {

    /**
     *
     * @param username
     * @return
     */
    NewsUser findByUserName(String username);

    /**
     *
     * @param uid
     * @return
     */
    NewsUser findByUid(Integer uid);

    /**
     *
     * @param newsUser
     * @return
     */
    Integer insertNewsUser(NewsUser newsUser);
}
