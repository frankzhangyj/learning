package com.microsoft.spring5.IOCImpl.service.serviceImpl;

import com.microsoft.spring5.IOCImpl.anno.Bean;
import com.microsoft.spring5.IOCImpl.anno.Di;
import com.microsoft.spring5.IOCImpl.dao.daoImpl.UserDaoImpl;
import com.microsoft.spring5.IOCImpl.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDaoImpl userDao;
    @Override
    public void add() {
        System.out.println("service add.....");
    }
}
