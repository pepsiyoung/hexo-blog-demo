package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                synchronized (list) {
                    try {
                        list.wait();
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(() -> {
            synchronized (list) {
                list.notify();
            }
        }, 3, TimeUnit.SECONDS);
    }
}
