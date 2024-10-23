package com.microsoft.ssm.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private int code = 200; //200成功状态码

    private boolean flag = true; //返回状态

    private Object data;  //返回具体数据


    public  static R ok(Object data){
        R r = new R();
        r.data = data;
        return r;
    }

    public static R  fail(Object data){
        R r = new R();
        r.code = 500; //错误码
        r.flag = false; //错误状态
        r.data = data;
        return r;
    }
}
