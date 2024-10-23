package com.microsoft.topNews.service.impl;

import com.microsoft.topNews.dao.NewsHeadLineDao;
import com.microsoft.topNews.dao.impl.NewsHeadlineDaoImpl;
import com.microsoft.topNews.pojo.NewsHeadline;
import com.microsoft.topNews.pojo.vo.HeadlineDetailVo;
import com.microsoft.topNews.pojo.vo.HeadlinePageVo;
import com.microsoft.topNews.pojo.vo.HeadlineQueryVo;
import com.microsoft.topNews.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    NewsHeadLineDao newsHeadLineDao = new NewsHeadlineDaoImpl();

    @Override
    public Map<String, Object> findPage(HeadlineQueryVo headLineQueryVo) {
        // 准备一个map,用于装分页的五项数据
        Map<String, Object> pageInfo = new HashMap<>();
        // 分页查询本页数据
        List<HeadlinePageVo> pageData = newsHeadLineDao.findPageList(headLineQueryVo);
        // 分页查询满足记录的总数据量
        int totalSize = newsHeadLineDao.findPageCount(headLineQueryVo);
        // 页大小
        int pageSize = headLineQueryVo.getPageSize();
        // 总页码数
        int totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
        // 当前页码数
        int pageNum = headLineQueryVo.getPageNum();
        pageInfo.put("pageData", pageData);
        pageInfo.put("pageNum", pageNum);
        pageInfo.put("pageSize", pageSize);
        pageInfo.put("totalPage", totalPage);
        pageInfo.put("totalSize", totalSize);


        return pageInfo;
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(Integer hid) {
        // 修改新闻信息浏览量+1
        newsHeadLineDao.increasePageViews(hid);
        // 查询新闻详情
        return newsHeadLineDao.findHeadlineDetail(hid);
    }

    @Override
    public Integer addNewsHeadline(NewsHeadline newsHeadline) {
            return newsHeadLineDao.addNewsHeadline(newsHeadline);
    }

    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
       return newsHeadLineDao.findHeadlineByHid(hid);
    }

    @Override
    public Integer updateNewsHeadline(NewsHeadline newsHeadline) {
        return newsHeadLineDao.updateNewsHeadline(newsHeadline);
    }

    @Override
    public Integer removeByHid(Integer hid) {
        return newsHeadLineDao.removeByHid(hid);
    }
}
