package com.microsoft.springMVC.controller;

import com.microsoft.springMVC.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 将请求体中的JSON转换为pojo需要通过Convert接口
 *              将pojo转换为响应体中JSON需要通过HttpMessageConvert接口  底层都是通过jackson实现
 * @Author frank
 * @Date 2024/10/12
 */
@RequestMapping("/book")
@Controller
public class BookController {
    /**
     * 一个处理器方法只能有一个 @RequestBody
     * @param users
     */
    @RequestMapping("/save")
    @ResponseBody
    public void save(@RequestBody List<User> users) {
        System.out.println(users);
    }

    /**
     * 转换日期 可以定义日期格式 spring自动将String类型转换为Date convert接口(将请求resp中的参数转换为其他格式)
     * @param date
     */
    @RequestMapping("/date")
    @ResponseBody
    public void converDate(@DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss") Date date) {
        System.out.println(date);
    }










    /**
     * 不加@ResponseBody会进行页面跳转
     * @return
     */
    @RequestMapping("/tansHtml")
    public String transHtml() {
        return "index.html";
    }

    /**
     * 加上@ResponseBody会默认返回String类型数据到响应体中 前端格式为txt
     * @return
     */
    @RequestMapping("/tansHtml")
    @ResponseBody
    public String transTxt() {
        return "i love you";
    }

    /**
     * 方法直接返回对象 spring 会自动通过HttpMessageConverter 中利用jackson 将对象转换为JSON
     * @return
     */
    @RequestMapping("/tansPojo")
    @ResponseBody
    public User transPojo() {
        User user = new User();
        return user;
    }

    @RequestMapping("/tansPojoList")
    @ResponseBody
    public List<User> transPojoList() {

        User user = new User();
        User user1 = new User();
        User user2 = new User();

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }
}
