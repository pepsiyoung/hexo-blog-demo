package com.pepsiyoung.web2.controller;

import com.pepsiyoung.web2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ConversionService conversionService;
    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/version")
    public LocalDateTime getVersion() {
        String source = "2020-12-01 12:23:23";
        return conversionService.convert(source, LocalDateTime.class);

//        Integer[] array = new Integer[3];
//        Integer[] convert = conversionService.convert(Arrays.asList(1, 2, 3),array.getClass());
//        System.out.println(convert);
    }

    @PostMapping("")
    public User store(@RequestBody User user) {
        return user;
    }

    @GetMapping("")
    public String get(@RequestParam LocalDateTime localDateTime) {
        return localDateTime.toString();
    }
}
