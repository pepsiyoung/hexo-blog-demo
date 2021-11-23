package com.pepsiyoung.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("cache")
public class CacheController {

    @GetMapping("test")
    public String test() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println("DB QPS :" + ThreadLocalRandom.current().nextInt(100));
        }, 0, 1, TimeUnit.SECONDS);
        return "cacheTest";
    }
}
