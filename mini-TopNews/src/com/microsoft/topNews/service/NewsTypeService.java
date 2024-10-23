package com.microsoft.topNews.service;

import com.microsoft.topNews.pojo.NewsType;

import java.util.List;

public interface NewsTypeService {
    /**
     *
     * @return
     */
    List<NewsType> findAll();
}
