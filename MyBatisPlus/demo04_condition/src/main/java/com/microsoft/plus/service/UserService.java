package com.microsoft.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microsoft.plus.pojo.User;

/**
 * @Description mybatisplus封装了CRUD到service层 需要继承一个接口（有一部分有默认实现 其他没有实现的在实现类中）继承一个实现类
 * @Author frank
 * @Date 2024/10/21
 */
public interface UserService extends IService<User> {
}
