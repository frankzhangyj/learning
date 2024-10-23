package com.microsoft.aop.annoAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * AOP的相关术语：
 * 连接点 类中可以被增强的方法
 * 切入点 实际被增强的方法
 * 通知 增强的逻辑部分 其中有一个切入点表达式("execution(* 类路径.方法名(..))")
 * 切面 把通知应用到切入点中
 */
@Component // IOC创建bean对象
@Aspect // 创建一个切面类
@Order(3) // 如果有多个代理类都需要增强同一个方法 那么可以设置一个优先级 数字越小越先执行
public class CalculateProxy {

    // 设置一个切入点注解 可以提取共同切入点表达式
    @Pointcut("execution(* com.microsoft.aop.annoAOP.Calculate.add(..))")
    public void pointCut() {}

    // 前置通知：在被代理的目标方法 前 执行
    @Before("pointCut()")
    public void befor(JoinPoint joinPoint) {
        System.out.println("CalculateProxy before..... 方法名：" + joinPoint.getSignature().getName());
    }

    // 后置通知：在被代理的目标方法 最终结束 后执行(相当于try catch中的final 不论是不是遇到异常 最终都会执行)
    @After("execution(* com.microsoft.aop.annoAOP.Calculate.add(..))")
    public void after() {
        System.out.println("after......");
    }

    // 环绕通知：在调用切入点 之前和之后 执行
    @Around("execution(* com.microsoft.aop.annoAOP.Calculate.add(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
            System.out.println("around before.....");
            result = proceedingJoinPoint.proceed();
            System.out.println("around after.....");
        } catch (Throwable e) {
            System.out.println("around exception");
        } finally {
            System.out.println("around finally");
        }

        return result;
    }

    // 异常通知：在被代理的目标方法 异常结束 后执行
    @AfterThrowing(value = "execution(* com.microsoft.aop.annoAOP.Calculate.add(..))", throwing = "ex")
    public void afterThrow(Throwable ex) {
        System.out.println("after throw..... 异常：" + ex);
    }

    // 返回通知：在被代理的目标方法 成功结束 后执行
    @AfterReturning(value = "execution(* com.microsoft.aop.annoAOP.Calculate.add(..))", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("after return...... 方法名：" + joinPoint.getSignature().getName() + "  return: " + result);
    }
}
