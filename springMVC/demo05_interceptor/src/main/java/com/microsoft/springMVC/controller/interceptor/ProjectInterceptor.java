package com.microsoft.springMVC.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 定义一个拦截器 用于处理在servlet之后controller之前进行拦截 需要添加一个springMVCwebSupport配置类
 *              实现和AOP类似 继承HandlerInterceptor 重写三个环绕方法
 * @Author frank
 * @Date 2024/10/13
 */
@Component
public class ProjectInterceptor implements HandlerInterceptor {
    /**
     * 当返回值为true时可以正常进入controller 否则拦截
     * @param request http原始请求
     * @param response http原始响应
     * @param handler 是HandlerMethod类型 也就是要调用的方法
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre....");
        HandlerMethod hm = (HandlerMethod) handler;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post....");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after....");
    }
}
