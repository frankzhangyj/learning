package com.microsoft.news.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName news_type
 */
@Data
public class Type implements Serializable {
    /**
     * 新闻类型id
     */
    @TableId()
    private Integer tid;

    /**
     * 新闻类型描述
     */
    private String tname;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 头条是否被删除 1 删除  0 未删除
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}