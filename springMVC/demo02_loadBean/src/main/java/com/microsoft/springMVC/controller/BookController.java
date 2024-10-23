package com.microsoft.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/12
 */
@RequestMapping("/book")
@Controller
public class BookController {
    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        System.out.println("book save..");
        return "{'bookname':'......'}";
    }
}
