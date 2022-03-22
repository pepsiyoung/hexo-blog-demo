package netty.other;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * 时间轮
 */
public class HashedWheelTimerTest {
    static class MyTimerTask implements TimerTask {

        boolean flag;

        public MyTimerTask(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run(Timeout timeout) throws Exception {
            System.out.println("要去数据库删除订单了。。。。");
//            this.flag = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTimerTask timerTask = new MyTimerTask(true);
        Timer timer = new HashedWheelTimer();
        timer.newTimeout(timerTask, 5, TimeUnit.SECONDS);
        timer.newTimeout(timerTask, 8, TimeUnit.SECONDS);

        int i = 1;
        while (timerTask.flag) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(i + "秒过去了");
            i++;
        }
        System.out.println("END");
    }
}
