package com.microsoft.plus.pojo;

import com.baomidou.mybatisplus.annotation.*;
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
/*@TableName("user")*/
// 默认是雪花算法 随机生成一个64位数字或字符串
public class User {
    // 利用雪花算法或者数据库自增主键设置主键
/*    @TableId(value = "id", type = IdType.AUTO)*/
    private Long id;
    // 设置属性名和字段名对应 可以设置存在在数据库中
/*    @TableField(value = "name", exist = true)*/
    private String name;
    private Integer age;
    private String email;

    @TableLogic
    //逻辑删除字段 int mybatis-plus下,默认 逻辑删除值为1 未逻辑删除 0
    private Integer deleted;

    @Version
    // 版本号实现乐观锁
    private Integer version;
}

