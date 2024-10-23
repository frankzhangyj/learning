package com.microsoft.news.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microsoft.news.mapper.UserMapper;
import com.microsoft.news.pojo.User;
import com.microsoft.news.service.UserService;
import com.microsoft.news.utils.JwtHelper;
import com.microsoft.news.utils.MD5Util;
import com.microsoft.news.utils.Result;
import com.microsoft.news.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyj123
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2024-10-22 17:02:18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MD5Util md5Util;
    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User loginUser = userMapper.selectOne(queryWrapper);

        if (loginUser == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        if (!StringUtils.isEmpty(user.getUserPwd()) && loginUser.getUserPwd().equals(MD5Util.encrypt(user.getUserPwd()))) {
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));

            Map data = new HashMap();
            data.put("token", token);

            return Result.ok(data);
        }

        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {

        if (jwtHelper.isExpiration(token)) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        Long userId = jwtHelper.getUserId(token);

        User user = userMapper.selectById(userId);

        if (user != null) {
            user.setUserPwd("");
            HashMap data = new HashMap<>();
            data.put("loginUser", user);
            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.NOTLOGIN);
    }

    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(User::getUsername, username);
        Long rows = userMapper.selectCount(queryWrapper);

        if (rows > 0) {
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        return Result.ok(null);
    }

    @Override
    public Result regist(User user) {
        Result result = checkUserName(user.getUsername());
        if (result.getCode() == ResultCodeEnum.USERNAME_USED.getCode()) {
            return result;
        }

        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        int insert = userMapper.insert(user);

        return Result.ok(null);
    }
}




