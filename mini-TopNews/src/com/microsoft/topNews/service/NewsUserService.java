package com.microsoft.topNews.service;

import com.microsoft.topNews.pojo.NewsUser;

public interface NewsUserService {

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
    Integer registUser(NewsUser newsUser);
}
