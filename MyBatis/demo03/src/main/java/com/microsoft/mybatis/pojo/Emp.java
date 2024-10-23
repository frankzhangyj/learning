package com.microsoft.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
        private Integer eid;
        private String empName;
        private Integer age;
        private String sex;
        private String email;
        private Dept dept;
}
