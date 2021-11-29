package proxy;

public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello Proxy");
    }
}
