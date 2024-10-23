package com.microsoft.topNews.controller;

import com.microsoft.topNews.common.Result;
import com.microsoft.topNews.pojo.NewsHeadline;
import com.microsoft.topNews.service.NewsHeadlineService;
import com.microsoft.topNews.service.impl.NewsHeadlineServiceImpl;
import com.microsoft.topNews.util.JwtHelper;
import com.microsoft.topNews.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController{
    NewsHeadlineService newsHeadlineService = new NewsHeadlineServiceImpl();

    /**
     * 发布新闻
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取新闻信息
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        // 通过token获取发布者ID
        String token = req.getHeader("token");
        Long userId = JwtHelper.getUserId(token);
        newsHeadline.setPublisher(userId.intValue());
        // 将新闻存入数据库
        newsHeadlineService.addNewsHeadline(newsHeadline);
        WebUtil.writeJson(resp, Result.ok(null));
    }

    /**
     * 修改新闻回显
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));
        NewsHeadline newsHeadline =newsHeadlineService.findHeadlineByHid(hid);
        Map<String ,Object> data =new HashMap<>();
        data.put("headline",newsHeadline);
        WebUtil.writeJson(resp,Result.ok(data));

    }

    /**
     * 更新新闻信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        newsHeadlineService.updateNewsHeadline(newsHeadline);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    /**
     * 删除新闻
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));
        newsHeadlineService.removeByHid(hid);
        WebUtil.writeJson(resp,Result.ok(null));
    }
}
