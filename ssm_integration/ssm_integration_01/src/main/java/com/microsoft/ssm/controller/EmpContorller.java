package com.microsoft.ssm.controller;

import com.microsoft.ssm.pojo.Employee;
import com.microsoft.ssm.service.EmpService;
import com.microsoft.ssm.service.impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
@RestController
@RequestMapping("/emp")
public class EmpContorller {
    @Autowired
    private EmpServiceImpl empService;

    @GetMapping("/list")
    public List<Employee> find() {
        List<Employee> employees = empService.findAll();
        return employees;
    }
}
