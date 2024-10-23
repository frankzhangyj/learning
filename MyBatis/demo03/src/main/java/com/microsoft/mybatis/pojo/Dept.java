package com.microsoft.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {
        private Integer did;
        private String deptName;
        private List<Emp> emps;
        //...构造器、get、set方法等
}
