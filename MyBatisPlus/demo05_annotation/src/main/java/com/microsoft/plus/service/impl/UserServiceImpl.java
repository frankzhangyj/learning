package com.microsoft.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microsoft.plus.mapper.UserMapper;
import com.microsoft.plus.pojo.User;
import com.microsoft.plus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
