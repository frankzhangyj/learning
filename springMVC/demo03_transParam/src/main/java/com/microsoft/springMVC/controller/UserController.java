package com.microsoft.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microsoft.springMVC.pojo.Address;
import java.util.List;

/**
 * @Description 用来接收key value类型的URL编码方式的表单数据 不区分get和post 不能处理请求体中的JSON数据
 * @Author frank
 * @Date 2024/10/12
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestParam("username") String name,@RequestParam("age") int age) {
        System.out.println("user save.... name: " + name + " age: " + age);
        return "fuck";
    }

    /**
     * 可以设置请求中的参数名和方法参数对应
     * @param name
     * @param age
     * @param address
     */
    @RequestMapping("/save1")
    @ResponseBody
    public void save(@RequestParam("username")String name, int age, Address address) {
        System.out.println(name + " " + age + " " + address);
    }

    /**
     * 自动将请求中的数据和数组名相同的插入到数组中
     * @param likes
     */
    @RequestMapping("/save2")
    @ResponseBody
    public void save(String[] likes) {
        System.out.println(likes);
    }

    /**
     * 这里如果是集合需要添加@RequestParam 使得spring将数据以参数的形式传入 而不是以属性形式传入
     * @param learns
     */
    @RequestMapping("/save3")
    @ResponseBody
    public void save(@RequestParam List<String> learns) {
        System.out.println(learns);
    }
}
