package com.microsoft.boot3.contorller;

import com.microsoft.boot3.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/20
 */
@RestController
@RequestMapping("/Emp")
public class EmpController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/list")
    public List<Emp> showAll() {
        String sql = "select * from t_emp_new;";
        List<Emp> emp = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));

        return emp;
    }
}
