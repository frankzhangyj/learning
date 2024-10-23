package com.microsoft.news.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.microsoft.news.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microsoft.news.pojo.vo.PortalVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author zyj123
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-10-22 17:02:18
* @Entity com.microsoft.news.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    IPage<Map> selectPageMap(IPage page, @Param("portalVo") PortalVo portalVo);

    Map selectDetailMap(Integer hid);
}




