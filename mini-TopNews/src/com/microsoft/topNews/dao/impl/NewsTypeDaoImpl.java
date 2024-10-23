package com.microsoft.topNews.dao.impl;

import com.microsoft.topNews.dao.BaseDao;
import com.microsoft.topNews.dao.NewsTypeDao;
import com.microsoft.topNews.pojo.NewsType;

import java.util.List;

public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {
    @Override
    public List<NewsType> findAll() {
        String sql = "select tid, tname from news_type";
        return baseQuery(NewsType.class, sql);
    }
}
