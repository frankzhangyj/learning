package com.microsoft.spring5.IOCImpl.bean;

/**
 * bean容器接口
 */
public interface ApplicationContext {
    Object getBean(Class clazz);
}
