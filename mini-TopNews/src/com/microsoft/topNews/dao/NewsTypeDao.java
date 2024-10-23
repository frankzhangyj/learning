package com.microsoft.topNews.dao;

import com.microsoft.topNews.pojo.NewsType;

import java.util.List;

public interface NewsTypeDao {
    /**
     *
     * @return
     */
    List<NewsType> findAll();
}
