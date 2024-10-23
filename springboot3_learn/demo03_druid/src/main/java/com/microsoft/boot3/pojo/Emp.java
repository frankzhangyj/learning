package com.microsoft.boot3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer emp_id;
    private String emp_name;
    private Double emp_salary;
}
