package com.pepsiyoung.web3.controller;

import com.pepsiyoung.web3.forest.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forest")
public class ForestController {

    @Autowired
    MyClient myClient;

    @GetMapping("")
    public String demo1(){
        return myClient.simpleRequest();
    }
}
