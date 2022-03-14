package netty.test;

import io.netty.util.concurrent.DefaultPromise;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OperationResultFuture operationResultFuture = new OperationResultFuture();


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(() -> operationResultFuture.setSuccess("AAA"), 3, TimeUnit.SECONDS);


        System.out.println("结果:" + operationResultFuture.get());
    }
}
