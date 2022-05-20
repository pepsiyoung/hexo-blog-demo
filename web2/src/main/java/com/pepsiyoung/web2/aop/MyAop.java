package com.pepsiyoung.web2.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {

    @AfterReturning(pointcut = "execution(public * com.pepsiyoung.web2.controller.AopController.returning(..))")
    public void returningHandler() {
        throw new RuntimeException("手动抛出异常。。。");
    }
}
