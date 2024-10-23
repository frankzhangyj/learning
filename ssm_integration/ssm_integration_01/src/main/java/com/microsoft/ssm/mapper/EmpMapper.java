package com.microsoft.ssm.mapper;

import com.microsoft.ssm.pojo.Employee;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
public interface EmpMapper {
    List<Employee> queryAll();
}
