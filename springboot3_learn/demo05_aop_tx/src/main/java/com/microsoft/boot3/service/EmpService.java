package com.microsoft.boot3.service;

import com.microsoft.boot3.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@Service
public class EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Transactional
    public void delete() {
        empMapper.delete(1);

        System.out.println("service delete id 1");
        int i = 1 / 0;
    }
}
