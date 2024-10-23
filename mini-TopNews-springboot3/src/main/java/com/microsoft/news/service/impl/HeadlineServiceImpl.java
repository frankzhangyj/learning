package com.microsoft.news.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microsoft.news.pojo.Headline;
import com.microsoft.news.pojo.vo.PortalVo;
import com.microsoft.news.service.HeadlineService;
import com.microsoft.news.mapper.HeadlineMapper;
import com.microsoft.news.utils.JwtHelper;
import com.microsoft.news.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyj123
 * @description 针对表【news_headline】的数据库操作Service实现
 * @createDate 2024-10-22 17:02:18
 */
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
        implements HeadlineService {
    @Autowired
    private HeadlineMapper headlineMapper;
    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result findNewPage(PortalVo portalVo) {
        LambdaQueryWrapper<Headline> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(portalVo.getKeyWords()), Headline::getTitle, portalVo.getKeyWords())
                .eq(portalVo.getType() != null, Headline::getType, portalVo.getType());

        IPage<Map> page = new Page(portalVo.getPageNum(), portalVo.getPageSize());

        headlineMapper.selectPageMap(page, portalVo);

        //4.结果封装
        //分页数据封装
        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("pageData", page.getRecords());
        pageInfo.put("pageNum", page.getCurrent());
        pageInfo.put("pageSize", page.getSize());
        pageInfo.put("totalPage", page.getPages());
        pageInfo.put("totalSize", page.getTotal());

        Map<String, Object> pageInfoMap = new HashMap<>();
        pageInfoMap.put("pageInfo", pageInfo);
        // 响应JSON
        return Result.ok(pageInfoMap);
    }

    @Override
    public Result getNewsDetail(Integer hid) {
        Map headLineDetail = headlineMapper.selectDetailMap(hid);
        //2.拼接头条对象(阅读量和version)进行数据更新
        Headline headline = new Headline();
        headline.setHid(hid);
        headline.setPageViews((Integer) headLineDetail.get("pageViews")+1); //阅读量+1
        headline.setVersion((Integer) headLineDetail.get("version")); //设置版本
        headlineMapper.updateById(headline);

        Map<String,Object> pageInfoMap=new HashMap<>();
        pageInfoMap.put("headline",headLineDetail);
        return Result.ok(pageInfoMap);
    }

    @Override
    public Result saveNews(Headline headline, String token) {
        Integer userId = jwtHelper.getUserId(token).intValue();
        headline.setPublisher(userId);
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headlineMapper.insert(headline);
        return Result.ok(null);
    }

    @Override
    public Result getNewsByHid(Integer hid) {
        Headline headline = headlineMapper.selectById(hid);
        Map<String, Object> map = new HashMap();
        map.put("headline", headline);
        return Result.ok(map);
    }

    @Override
    public Result updateNews(Headline headline) {
        Integer version = headlineMapper.selectById(headline).getVersion();

        headline.setVersion(version);
        headline.setUpdateTime(new Date());
        headlineMapper.updateById(headline);

        return Result.ok(null);
    }
}




