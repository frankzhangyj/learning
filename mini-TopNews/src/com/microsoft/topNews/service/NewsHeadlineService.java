package com.microsoft.topNews.service;

import com.microsoft.topNews.pojo.NewsHeadline;
import com.microsoft.topNews.pojo.vo.HeadlineDetailVo;
import com.microsoft.topNews.pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {
    /**
     * 分页查询
     * @param headLineQueryVo
     * @return
     */
    Map<String, Object> findPage(HeadlineQueryVo headLineQueryVo);

    /**
     * 联合查询详细新闻
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(Integer hid);

    /**
     * 添加一个新闻
     * @param newsHeadline
     * @return
     */
    Integer addNewsHeadline(NewsHeadline newsHeadline);

    /**
     * 查找新闻
     * @param hid
     * @return
     */
    NewsHeadline findHeadlineByHid(Integer hid);

    /**
     * 更新
     * @param newsHeadline
     * @return
     */
    Integer updateNewsHeadline(NewsHeadline newsHeadline);

    /**
     * 删除
     * @param hid
     */
    Integer removeByHid(Integer hid);
}
