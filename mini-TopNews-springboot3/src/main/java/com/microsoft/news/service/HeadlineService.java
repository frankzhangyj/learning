package com.microsoft.news.service;

import com.microsoft.news.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.microsoft.news.pojo.vo.PortalVo;
import com.microsoft.news.utils.Result;

/**
* @author zyj123
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-10-22 17:02:18
*/
public interface HeadlineService extends IService<Headline> {

    /**
     * 分页查询
     * @param portalVo
     * @return
     */
    Result findNewPage(PortalVo portalVo);

    /**
     * 详细信息
     * @param hid
     * @return
     */
    Result getNewsDetail(Integer hid);

    /**
     * 发布新闻
     * @param headline
     * @param token
     * @return
     */
    Result saveNews(Headline headline, String token);

    /**
     * 回显新闻
     * @param hid
     * @return
     */
    Result getNewsByHid(Integer hid);

    /**
     * 更新新闻
     * @param headline
     * @return
     */
    Result updateNews(Headline headline);
}
