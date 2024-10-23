package com.microsoft.boot3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer empId;
    private String empName;
    private Double empSalary;
}
