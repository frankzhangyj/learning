package com.microsoft.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microsoft.news.pojo.Type;
import com.microsoft.news.service.TypeService;
import com.microsoft.news.mapper.TypeMapper;
import com.microsoft.news.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author zyj123
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-10-22 17:02:18
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{
}




