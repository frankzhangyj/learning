package com.microsoft.topNews.dao;

import com.microsoft.topNews.pojo.NewsHeadline;
import com.microsoft.topNews.pojo.vo.HeadlineDetailVo;
import com.microsoft.topNews.pojo.vo.HeadlinePageVo;
import com.microsoft.topNews.pojo.vo.HeadlineQueryVo;

import java.util.List;

public interface NewsHeadLineDao {
    /**
     *
     * @param headLineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headLineQueryVo);

    /**
     *
     * @param headLineQueryVo
     * @return
     */
    int findPageCount(HeadlineQueryVo headLineQueryVo);

    /**
     *
     * @param hid
     */
    void increasePageViews(Integer hid);

    /**
     *
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(Integer hid);

    /**
     *
     * @param newsHeadline
     * @return
     */
    Integer addNewsHeadline(NewsHeadline newsHeadline);

    /**
     *
     * @param hid
     * @return
     */
    NewsHeadline findHeadlineByHid(Integer hid);

    /**
     *
     * @param newsHeadline
     * @return
     */
    Integer updateNewsHeadline(NewsHeadline newsHeadline);

    /**
     * 逻辑删除
     * @param hid
     * @return
     */
    Integer removeByHid(Integer hid);
}
