package com.microsoft.ssm.service.impl;

import com.microsoft.ssm.mapper.EmpMapper;
import com.microsoft.ssm.pojo.Employee;
import com.microsoft.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = empMapper.queryAll();
        return employees;
    }
}
