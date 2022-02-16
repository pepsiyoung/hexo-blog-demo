package com.pepsiyoung.web.controller;

import com.pepsiyoung.web.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/demo1")
    public User demo1() {
        User user = new User();
        user.setId(1);
        user.setLocalDateTime(LocalDateTime.now());

        try {
            int a = 0;
            int res = 10 / a;
            System.out.println(res);
        } catch (Exception e) {
            user.setId(2);
            return user;
        }

        return user;
    }
}
