package com.microsoft.spring5.lifeCircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean后置处理器 在bean初始化之前和之后调用
 * 会在当前xml配置文件中所有的bean都加上后置处理器
 */
public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之前调用处理器");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之后调用处理器");
        return bean;
    }
}
