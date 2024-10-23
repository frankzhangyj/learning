package com.microsoft.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/12
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(String name, int age) {
        System.out.println("user save.... name: " + name + " age: " + age);
        return "{'username':'......'}";
    }
}
