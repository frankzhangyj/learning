package com.microsoft.springMVC.controller;

import com.microsoft.springMVC.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description restful 获取请求中的数据
 * @RequestParam 用于接收url地址传参或者表单传参 不限制get post等方法 用的少
 * @RequesBody 用于接收JSON数据
 * @PathVariable 用于接收路径参数 使用{参数}描述路径参数 通常用于传递id值
 * @Author frank
 * @Date 2024/10/12
 */
@Controller
@RequestMapping("/users")
public class UserController {
    /**
     * 增加操作post和更新操作put都是通过请求体中的JSON格式获取数据 映射路径都只有一个英文单词
     *
     * @param user
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void saveUser(@RequestBody User user) {
    }

    @RequestMapping( method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@RequestBody User user) {
    }

    /**
     * 删除操作delete和查询操作get都是通过url中的参数获取数据 映射路径为单词 + {参数}
     * 需要在参数前添加@PathVariable对应映射路径上的变量名
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User queryUser(@PathVariable int id) {
        User user = new User();
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable int id) {
    }
}