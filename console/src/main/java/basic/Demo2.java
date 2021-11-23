package basic;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo2 {

    static final LinkedList<String> list = new LinkedList<>();
    public static void main(String[] args) throws InterruptedException {
        List<String> subscriberList = Arrays.asList("小明", "小虎", "小胖");
        for (String name : subscriberList) {
            Thread t1 = new Thread(() -> subscriber(name));
            t1.start();
        }

        List<String> publisherList = Arrays.asList("EDG夺冠了", "周董出新专辑了", "觉得这篇文章写得好");
        for (String s : publisherList) {
            TimeUnit.SECONDS.sleep(3);
            publisher(s);
        }
    }

    @SneakyThrows
    public static void subscriber(String name) {
        System.out.println(name + "订阅了通知");
        synchronized (list) {
            while (true) {
                list.wait();
                System.out.printf("%s收到消息[%s] %n", name, list.getLast());
            }
        }
    }

    public static void publisher(String message) {
        synchronized (list) {
            list.add(message);
            list.notifyAll();
        }
    }
}
