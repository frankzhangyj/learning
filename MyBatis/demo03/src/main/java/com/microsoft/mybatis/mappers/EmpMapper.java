package com.microsoft.mybatis.mappers;

import com.microsoft.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/15
 */
public interface EmpMapper {
    Emp getEmpAndDept(@Param("eid")Integer eid);

    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);

    List<Emp> getEmpByCondition(Emp emp);

    insertMoreByList(@Param("eids") Integer[] eids);

}
