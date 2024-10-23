package com.microsoft.mybatis.mappers;

import com.microsoft.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/15
 */
public interface DeptMapper {
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);

}
