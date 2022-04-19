package com.pepsiyoung.web2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pepsiyoung.web2.entity.Person;
import com.pepsiyoung.web2.mapper.PersonMapper;
import com.pepsiyoung.web2.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonService iPersonService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PersonMapper personMapper;

    @GetMapping("test")
    public List<Person> test() {
        return personMapper.getCustomList();
    }

    @GetMapping("")
    public IPage<Person> getList() {
        LambdaQueryWrapper<Person> lambdaQueryWrapper = new LambdaQueryWrapper<Person>()
                .eq(Person::getHobbyId, "1")
                .lt(Person::getCreateTime, LocalDateTime.now());
        return iPersonService.page(Page.of(1, 10), lambdaQueryWrapper);
    }

    @GetMapping("/{id}")
    public Person getOne(@PathVariable String id) {
        return iPersonService.getById(id);
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
