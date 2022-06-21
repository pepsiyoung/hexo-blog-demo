package basic;

import java.text.ParseException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo3 {

    private final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);
    private final static CyclicBarrier BARRIER = new CyclicBarrier(10);

    public static void main(String[] args) throws ParseException {

        for (int i = 0; i < 10; i++) {
            final String name = "玩家" + i;
            EXECUTOR_SERVICE.execute(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println(name + "已准备,等待其他玩家准备...");
                    BARRIER.await();
                    Thread.sleep(1000);
                    System.out.println(name + "已加入游戏");
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println(name + "离开游戏");
                }
            });
        }
        EXECUTOR_SERVICE.shutdown();
    }
}
