package com.microsoft.listeners;

import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import jakarta.servlet.http.HttpSessionEvent;

/**
 * 与application域监听类似 多了两个监听器
 *      绑定监听器: 监听当前监听器添加为session属性 和 移除这个监听器属性
 *      钝化活化监听器: 钝化: session序列化后从服务器存入磁盘
 *                      活化: session反序列化后从磁盘回到服务器
 */
public class MySessionListener implements HttpSessionBindingListener, HttpSessionActivationListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        // 在钝化之前执行
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        // 在活化之后执行
    }
}
