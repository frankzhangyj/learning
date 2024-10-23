package com.microsoft.ssm.service;

import com.microsoft.ssm.pojo.Employee;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
public interface EmpService {
    List<Employee> findAll();
}
