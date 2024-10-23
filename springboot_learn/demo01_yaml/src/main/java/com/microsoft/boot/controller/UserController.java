package com.microsoft.boot.controller;

import com.microsoft.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/19
 */
@RestController
public class UserController {
    @Autowired
    private User user;
    @RequestMapping("/hello")
    public User hello() {
        return user;
    }
}
