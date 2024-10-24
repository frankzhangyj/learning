package com.microsoft.topNews.controller;

import com.microsoft.topNews.common.Result;
import com.microsoft.topNews.common.ResultCodeEnum;
import com.microsoft.topNews.pojo.NewsUser;
import com.microsoft.topNews.service.NewsUserService;
import com.microsoft.topNews.service.impl.NewsUserServiceImpl;
import com.microsoft.topNews.util.JwtHelper;
import com.microsoft.topNews.util.MD5Util;
import com.microsoft.topNews.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class NewsUserController extends BaseController {
    NewsUserService newsUserService = new NewsUserServiceImpl();

    /**
     * 通过帐号密码登录
     * @param req 请求体中包含帐号密码
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser newsUser = WebUtil.readJson(req, NewsUser.class);

        Result result = null;
        NewsUser loginNewsUser = newsUserService.findByUserName(newsUser.getUsername());
        // 判断用户名
        if (null != loginNewsUser) {
            // 判断密码
            if (loginNewsUser.getUserPwd().equals(MD5Util.encrypt(newsUser.getUserPwd()))) {
                // 密码正确
                Map<String, Object> data = new HashMap<>();
                // 生成token口令
                String token = JwtHelper.createToken(loginNewsUser.getUid().longValue());
                // 封装数据map
                data.put("token", token);
                // 封装结果
                result = Result.ok(data);
            } else {
                // 封装密码错误结果
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        } else {
            // 封装用户名错误结果
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        // 响应结果
        WebUtil.writeJson(resp, result);
    }

    /**
     * 通过token得到用户信息
     * @param req 请求头中包含一个token
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result  result =Result.build(null,ResultCodeEnum.NOTLOGIN);
        if(null!= token){
            if (!JwtHelper.isExpiration(token)) {
                Integer uid = JwtHelper.getUserId(token).intValue();
                NewsUser newsUser =newsUserService.findByUid(uid);
                newsUser.setUserPwd("");
                Map<String,Object> data =new HashMap<>();
                data.put("loginUser",newsUser);
                result=Result.ok(data);
            }
        }
        WebUtil.writeJson(resp,result);
    }

    /**
     * 检查帐号是否已经被占用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        NewsUser newsUser = newsUserService.findByUserName(username);
        Result result=null;
        if (null == newsUser){
            result=Result.ok(null);
        }else{
            result=Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    /**
     * 将注册数据加入到数据库中
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到前端请求体中的json
        NewsUser newsUser = WebUtil.readJson(req, NewsUser.class);
        // 防止同时注册时有相同帐号
        NewsUser usedUser = newsUserService.findByUserName(newsUser.getUsername());
        Result result=null;
        if (null == usedUser){
            newsUserService.registUser(newsUser);
            result=Result.ok(null);
        }else{
            result=Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    /**
     * 通过token检验用户登录是否过期
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result  result =Result.build(null,ResultCodeEnum.NOTLOGIN);
        if(null!= token){
            if (!JwtHelper.isExpiration(token)) {
                result=Result.ok(null);
            }
        }
        WebUtil.writeJson(resp,result);
    }
}
