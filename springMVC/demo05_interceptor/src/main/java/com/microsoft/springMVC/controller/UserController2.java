package com.microsoft.springMVC.controller;

import com.microsoft.springMVC.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 简化注解
 * @Author frank
 * @Date 2024/10/13
 */
@RestController // 相当于@Controller @ResponseBody
@RequestMapping("/users2")
public class UserController2 {

    @PostMapping
    public void saveUser(@RequestBody User user) {
        // 实现保存用户的逻辑
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        // 实现更新用户的逻辑
    }

    @GetMapping("/query/{id}")
    public User queryUser(@PathVariable int id) {
        User user = new User();
        // 实现查询用户的逻辑，应从数据库或其他数据源获取
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        // 实现删除用户的逻辑
    }
}
