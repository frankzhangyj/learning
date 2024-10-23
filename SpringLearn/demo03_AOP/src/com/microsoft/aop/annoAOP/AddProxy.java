package com.microsoft.aop.annoAOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class AddProxy {
    @Before("execution(* com.microsoft.aop.annoAOP.Calculate.add(..))")
    public void befor() {
        System.out.println("addProxy before.....");
    }
}
