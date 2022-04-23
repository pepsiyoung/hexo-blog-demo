package com.pepsiyoung.web3.controller;

import com.pepsiyoung.web3.entity.Bar;
import com.pepsiyoung.web3.entity.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/converter")
public class ConverterController {

    @Autowired
    ConversionService conversionService;

    @GetMapping("/person/{foo}")
    public Foo getFoo(@PathVariable Foo foo) {
        System.out.println(foo);
        return foo;
    }

    @GetMapping("/time")
    public LocalDateTime getTime(@RequestParam LocalDateTime localDateTime) {
        return localDateTime;
    }

    @GetMapping("")
    public String getDemo() {
        LocalDateTime time = conversionService.convert("2020-12-01 12:23:23", LocalDateTime.class);
        Bar bar = conversionService.convert("bar-998", Bar.class);
        System.out.println(time);
        System.out.println(bar);
        return "OK";
    }
}
