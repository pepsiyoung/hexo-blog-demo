package com.pepsiyoung.web3.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class FooFactoryBean implements FactoryBean<Foo>, InitializingBean {

    private String name;

    private Foo foo;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Foo getObject() throws Exception {
        return this.foo;
    }

    @Override
    public Class<?> getObjectType() {
        return Foo.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.foo = new Foo();
        this.foo.setName(this.name);
    }
}
