package proxy;

import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static void main(String[] args) {
        // JDK Proxy
        Hello hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        Hello proxyHello = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        proxyHello.sayHello();


    }
}
