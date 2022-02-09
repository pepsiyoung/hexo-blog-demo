package com.pepsiyoung.web.controller;

import lombok.Getter;
import lombok.Synchronized;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequestMapping("sync")
public class SyncController {

    private static final String locker = "locker";

    @GetMapping("wrong")
    public int wrong(@RequestParam(value = "count", defaultValue = "1000000") int count) {
        Data.reset();
        //多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new Data().wrong());
        return Data.getCounter();
    }

    @GetMapping("right")
    public int right(@RequestParam(value = "count", defaultValue = "1000000") int count) {
        Data.reset();
        //多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new Data().right());
        return Data.getCounter();
    }

    @Component
    static class Data {
        @Getter
        private static int counter = 0;

        public static int reset() {
            counter = 0;
            return counter;
        }

        @Synchronized
        public void wrong() {
            counter++;
        }

        public void right() {
            synchronized (locker) {
                counter++;
            }
        }
    }
}
