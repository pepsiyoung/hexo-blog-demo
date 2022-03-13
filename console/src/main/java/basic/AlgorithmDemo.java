package basic;

import sort.OrderDelay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class AlgorithmDemo {

    public static void main(String[] args) throws InterruptedException {

        DelayQueue<OrderDelay> queue = new DelayQueue<>();
        queue.put(new OrderDelay("AAA", TimeUnit.NANOSECONDS.convert(6, TimeUnit.SECONDS)));
        queue.add(new OrderDelay("BBB", TimeUnit.NANOSECONDS.convert(2, TimeUnit.SECONDS)));

        while (!queue.isEmpty()) {
            queue.take().print();
        }
    }

}
