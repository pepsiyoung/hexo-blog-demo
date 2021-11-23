package com.pepsiyoung.rabbitmq.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class RabbitConfig {

    public static final String SIMPLE_QUEUE_NAME = "simple_queue";

    public static final String DELAY_QUEUE_ONE_NAME = "delay_queue_one";

    public static final String DELAY_QUEUE_TWO_NAME = "delay_queue_two";

    public static final String DELAY_EXCHANGE = "my.delay.direct";

    // 创建队列
    @Bean
    public Queue simpleQueue() {
        return new Queue(RabbitConfig.SIMPLE_QUEUE_NAME, true);
    }

    @Bean
    public Queue delayQueueOne() {
        return new Queue(RabbitConfig.DELAY_QUEUE_ONE_NAME, true);
    }

    @Bean
    public Queue delayQueueTwo() {
        return new Queue(RabbitConfig.DELAY_QUEUE_TWO_NAME, true);
    }

    // 创建交换机
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("x-delayed-type", "fanout");
        return new CustomExchange(DELAY_EXCHANGE, "x-delayed-message", true, false, pMap);
    }

    // 队列与交换机绑定
    @Bean
    public Binding delayQueueOneBind() {
        return BindingBuilder.bind(delayQueueOne()).to(delayExchange()).with("").noargs();
    }

    @Bean
    public Binding delayQueueTwoBind() {
        return BindingBuilder.bind(delayQueueTwo()).to(delayExchange()).with("").noargs();
    }


    // 定义消息转换器
    @Bean
    Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // 定义消息模板用于发布消息，并且设置其消息转换器
    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
}
