package com.microsoft.boot3.controller;

import com.microsoft.boot3.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private User user;
    @GetMapping("/show")
    public User showUser() {
        return user;
    }
}
