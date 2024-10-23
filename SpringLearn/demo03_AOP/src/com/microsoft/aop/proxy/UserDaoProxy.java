package com.microsoft.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class UserDaoProxy implements InvocationHandler {

    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * 当代理对象创建完成后自动调用
     * @param proxy 当前代理对象
     *
     * @param method 代理对象调用的方法
     *
     * @param args 调用方法时携带的参数
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object res = null;
        if (methodName == "add") {
            System.out.println("before add");
            res = method.invoke(obj, args);
            System.out.println("after add");
        } else if (methodName == "update") {
            System.out.println("before update");
            res = method.invoke(obj, args);
            System.out.println("after update");
        }
        return res;
    }
}
