package com.pepsiyoung.web2.controller;

import com.pepsiyoung.web2.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/converter")
public class ConverterController {

    @GetMapping("/localDateTime/{localDateTime}")
    public User localDateTime(@PathVariable LocalDateTime localDateTime) {
        return User.builder().birthday(localDateTime).build();
    }

    @GetMapping("/localDate/{localDate}")
    public String localDateTime(@PathVariable LocalDate localDate) {
        return localDate.toString();
    }
}
