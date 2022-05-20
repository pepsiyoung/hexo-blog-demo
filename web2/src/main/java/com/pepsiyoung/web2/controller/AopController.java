package com.pepsiyoung.web2.controller;

import com.pepsiyoung.web2.entity.Person;
import com.pepsiyoung.web2.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    IPersonService personService;

    @GetMapping("/returning")
    @Transactional
    public Person returning() {
        Person person = personService.getById(1);
        person.setCreateTime(LocalDateTime.now());
        personService.updateById(person);
        return person;
    }
}
