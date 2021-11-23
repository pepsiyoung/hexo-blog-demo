package com.pepsiyoung.rabbitmq.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("rabbit")
public class IndexController {

    @Autowired
    RabbitmqPublish rabbitmqPublish;

    @GetMapping("simple")
    public String publishSimpleMessage() {
        rabbitmqPublish.sendSimpleMsg("简单消息" + new Date().getTime());
        return "发送完成";
    }

    @GetMapping("delay")
    public String publishDelayMessage() {
        Article article = Article.builder().title("三体").author("刘慈欣").content("正文。。。").build();
        rabbitmqPublish.sendDelayMsg(article, 2);
        rabbitmqPublish.sendDelayMsg(article, 5);
//        rabbitmqPublish.sendDelayMsg(article, 8);
        return "延时消息发送完成:" + new Date().getTime();
    }
}
