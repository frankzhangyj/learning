package com.microsoft.topNews.service.impl;

import com.microsoft.topNews.dao.NewsTypeDao;
import com.microsoft.topNews.dao.impl.NewsTypeDaoImpl;
import com.microsoft.topNews.pojo.NewsType;
import com.microsoft.topNews.service.NewsTypeService;

import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {
    NewsTypeDao newsTypeDao = new NewsTypeDaoImpl();
    @Override
    public List<NewsType> findAll() {
        return newsTypeDao.findAll();
    }
}
