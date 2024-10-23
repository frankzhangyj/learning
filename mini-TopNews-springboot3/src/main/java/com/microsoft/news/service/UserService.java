package com.microsoft.news.service;

import com.microsoft.news.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.microsoft.news.utils.Result;

/**
* @author zyj123
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-10-22 17:02:18
*/
public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param user
     * @return
     */
    Result login(User user);

    /**
     * 通过token获得用户信息
     * @param token
     * @return
     */
    Result getUserInfo(String token);

    /**
     * 检查用户名是否占用
     * @param username
     * @return
     */
    Result checkUserName(String username);

    /**
     * 先检查用户名是否占用 再添加
     * @param user
     * @return
     */
    Result regist(User user);
}
