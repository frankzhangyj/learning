package com.microsoft.spring5.lifeCircle;

/**
 * bean的生命周期共7步
 * 1 无参构造 创建了实例
 * 2 调用set方法 注入属性
 * 初始化之前调用处理器
 * 3 执行配置初始化初始化
 * 初始化之后调用处理器
 * 4 执行了bean
 * 5 关闭IOC容器 执行销毁 手动调用close
 */
public class LifeCircle {
    private String name;

    public LifeCircle() {
        System.out.println("1 无参构造 创建了实例");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2 调用set方法 注入属性");
    }

    public void initMethod() {
        System.out.println("3 执行初始化");
    }

    public void destroyMethod() {
        System.out.println("5 执行销毁");
    }
}
