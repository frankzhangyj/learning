package com.microsoft.boot3.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/21
 */
@Component
@Aspect
public class EmpAdvice {
    @Before("execution(* com.microsoft.boot3.service.EmpService.*(..))")
    public void before(JoinPoint point) {
        String ClassName = point.getClass().getName();
        String MethodName = point.getSignature().getName();
        System.out.println("before " + ClassName + " " + MethodName + "()");
    }
}
