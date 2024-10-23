package com.microsoft.topNews.dao.impl;

import com.microsoft.topNews.dao.BaseDao;
import com.microsoft.topNews.dao.NewsHeadLineDao;
import com.microsoft.topNews.pojo.NewsHeadline;
import com.microsoft.topNews.pojo.vo.HeadlineDetailVo;
import com.microsoft.topNews.pojo.vo.HeadlinePageVo;
import com.microsoft.topNews.pojo.vo.HeadlineQueryVo;

import java.util.LinkedList;
import java.util.List;

public class NewsHeadlineDaoImpl extends BaseDao implements NewsHeadLineDao {
    /**
     * 分页查询得到以下数据集合
     * "hid":"1",                     // 新闻id
     * "title":"尚硅谷宣布 ... ...",   // 新闻标题
     * "type":"1",                    // 新闻所属类别编号
     * "pageViews":"40",              // 新闻浏览量
     * "pastHours":"3" ,              // 发布时间已过小时数
     * "publisher":"1"                // 发布用户ID
     *
     * @param headLineQueryVo
     * @return
     */
    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headLineQueryVo) {
        //  拼接动态 SQL,拼接参数
        List<Object> args = new LinkedList<>();
        String sql = "select hid,title,type,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,publisher from news_headline where is_deleted=0 ";
        StringBuilder sqlBuffer = new StringBuilder(sql);
        String keyWords = headLineQueryVo.getKeyWords();
        if (null != keyWords && !(keyWords.equals(""))) {
            sqlBuffer.append("and title like ? ");
            args.add("%" + keyWords + "%");
        }
        Integer type = headLineQueryVo.getType();
        if (null != type && type != 0) {
            sqlBuffer.append("and type  =  ? ");
            args.add(type);
        }

        sqlBuffer.append("order by pastHours , page_views desc ");
        // limit分页查询 从第 N 条记录开始, 返回 M 条记录
        sqlBuffer.append("limit ? , ?");
        args.add((headLineQueryVo.getPageNum() - 1) * headLineQueryVo.getPageSize());
        args.add(headLineQueryVo.getPageSize());

        // 参数转数组
        Object[] argsArr = args.toArray();
        System.out.println(sqlBuffer.toString());
        List<HeadlinePageVo> pageData = baseQuery(HeadlinePageVo.class, sqlBuffer.toString(), argsArr);

        return pageData;
    }

    @Override
    public int findPageCount(HeadlineQueryVo headLineQueryVo) {
        //  拼接动态 SQL,拼接参数
        List<Object> args = new LinkedList<>();
        String sql = "select count(1) from news_headline where is_deleted=0 ";
        StringBuilder sqlBuffer = new StringBuilder(sql);
        String keyWords = headLineQueryVo.getKeyWords();
        //判断并动态拼接条件
        if (null != keyWords && keyWords.length() > 0) {
            sqlBuffer.append("and title like ? ");
            args.add("%" + keyWords + "%");
        }
        //  判断并动态拼接条件
        Integer type = headLineQueryVo.getType();
        if (null != type && type != 0) {
            sqlBuffer.append("and type  =  ? ");
            args.add(type);
        }

        // 参数转数组
        Object[] argsArr = args.toArray();
        System.out.println(sqlBuffer.toString());
        Long totalSize = baseQueryObject(Long.class, sqlBuffer.toString(), argsArr);
        // 返回数据
        return totalSize.intValue();
    }

    @Override
    public void increasePageViews(Integer hid) {
        String sql = "update news_headline set page_views = page_views +1 where hid =?";
        baseUpdate(sql, hid);
    }

    /**
     * 联合查询详细新闻
     *
     * @param hid
     * @return
     */
    @Override
    public HeadlineDetailVo findHeadlineDetail(Integer hid) {
        String sql = "select hid,title,article,type, tname typeName ,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,publisher,nick_name author from news_headline h left join  news_type t on h.type = t.tid left join news_user u  on h.publisher = u.uid where hid = ?";
        List<HeadlineDetailVo> headlineDetailVoList = baseQuery(HeadlineDetailVo.class, sql, hid);
        if (null != headlineDetailVoList && headlineDetailVoList.size() > 0) return headlineDetailVoList.get(0);
        return null;
    }

    @Override
    public Integer addNewsHeadline(NewsHeadline newsHeadline) {
        String sql = "insert into news_headline values(DEFAULT,?,?,?,?,0,NOW(),NOW(),0)";

        return baseUpdate(sql, newsHeadline.getTitle(), newsHeadline.getArticle(), newsHeadline.getType(), newsHeadline.getPublisher());
    }

    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
        String sql = "select hid,title,article,type,publisher,page_views pageViews from news_headline where hid =?";
        List<NewsHeadline> newsHeadlineList = baseQuery(NewsHeadline.class, sql, hid);
        if (null != newsHeadlineList && newsHeadlineList.size() > 0)
            return newsHeadlineList.get(0);
        return null;
    }

    @Override
    public Integer updateNewsHeadline(NewsHeadline newsHeadline) {
        String sql = "update news_headline set title = ?, article= ? , type =? , update_time = NOW() where hid = ? ";
        return baseUpdate(
                sql,
                newsHeadline.getTitle(),
                newsHeadline.getArticle(),
                newsHeadline.getType(),
                newsHeadline.getHid()
        );
    }

    @Override
    public Integer removeByHid(Integer hid) {
        String sql = "update news_headline set is_deleted =1 ,  update_time =NOW() where hid = ? ";
        return baseUpdate(sql, hid);
    }
}
