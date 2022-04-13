package com.pepsiyoung.web2.controller;

import com.pepsiyoung.web2.entity.Person;
import com.pepsiyoung.web2.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonService iPersonService;

    @GetMapping("")
    public List<Person> getList() {
        return iPersonService.list();
    }

    @PostMapping("")
    public Boolean insert() {
        Person.Configure configure = new Person.Configure();


        Person person = new Person();
        person.setName("zzz");
        person.setHobbyId("1");
        person.setCreateTime(LocalDateTime.now());
        person.setConfigure(configure);
        return iPersonService.save(person);
    }
}
