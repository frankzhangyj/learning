package com.microsoft.topNews.controller;

import com.microsoft.topNews.common.Result;
import com.microsoft.topNews.pojo.NewsType;
import com.microsoft.topNews.pojo.vo.HeadlineDetailVo;
import com.microsoft.topNews.pojo.vo.HeadlineQueryVo;
import com.microsoft.topNews.service.NewsHeadlineService;
import com.microsoft.topNews.service.NewsTypeService;
import com.microsoft.topNews.service.impl.NewsHeadlineServiceImpl;
import com.microsoft.topNews.service.impl.NewsTypeServiceImpl;
import com.microsoft.topNews.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private NewsHeadlineService headlineService=new NewsHeadlineServiceImpl();
    private NewsTypeService newsTypeService=new NewsTypeServiceImpl();

    /**
     * 查询新闻类型
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NewsType> newsTypeList =newsTypeService.findAll();
        WebUtil.writeJson(resp, Result.ok(newsTypeList));
    }

    /**
     * 分页带条件查询新闻
     * 当带有关键字时 pagenum自动转换为 1 即将结果从第一页展示到前端
     * 如果没有关键字 pagenum就是用户选择的页数 将结果从当前页展示到前端
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HeadlineQueryVo headLineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        // 查询分页五项数据
        Map<String,Object> pageInfo =headlineService.findPage(headLineQueryVo);
        // 将分页五项数据放入PageInfoMap
        Map<String,Object> pageInfoMap=new HashMap<>();
        pageInfoMap.put("pageInfo",pageInfo);
        // 响应JSON
        WebUtil.writeJson(resp, Result.ok(pageInfoMap));
    }

    /**
     * 查询单个新闻详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要查询的详情新闻id
        Integer hid =Integer.parseInt(req.getParameter("hid"));

        // 查询新闻详情vo
        HeadlineDetailVo headlineDetailVo =headlineService.findHeadlineDetail(hid);
        // 封装data内容
        Map<String ,Object> data =new HashMap<>();
        data.put("headline",headlineDetailVo);
        // 响应JSON
        WebUtil.writeJson(resp,Result.ok(data));
    }
}
