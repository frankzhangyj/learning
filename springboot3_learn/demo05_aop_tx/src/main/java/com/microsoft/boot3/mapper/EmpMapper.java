package com.microsoft.boot3.mapper;

import com.microsoft.boot3.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
public interface EmpMapper {
    List<Emp> queryAll();

    int delete(@Param("id") int id);
}
