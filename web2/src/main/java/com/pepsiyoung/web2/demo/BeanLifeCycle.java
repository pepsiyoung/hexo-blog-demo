package com.pepsiyoung.web2.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BeanLifeCycle {

    public BeanLifeCycle() {
        System.out.println("BeanLifeCycle构造函数");
    }

    public void shutdown() {
        System.out.println("执行：shutdown");
    }

    public void customClose() {
        System.out.println("执行：customClose");
    }
}
