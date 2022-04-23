package com.pepsiyoung.web2.demo;

public class BeanLifeCycle {

    public void shutdown() {
        System.out.println("执行：shutdown");
    }

    public void customClose(){
        System.out.println("执行：customClose");
    }
}
