package com.microsoft.boot3.controller;

import com.microsoft.boot3.mapper.EmpMapper;
import com.microsoft.boot3.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpMapper empMapper;

    @GetMapping("/list")
    public List<Emp> query() {
        return empMapper.queryAll();
    }
}
