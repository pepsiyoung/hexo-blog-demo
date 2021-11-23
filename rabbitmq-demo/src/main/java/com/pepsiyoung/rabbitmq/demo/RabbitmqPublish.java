package com.pepsiyoung.rabbitmq.demo;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 发布者
 */
@Component
public class RabbitmqPublish {

    private final RabbitTemplate rabbitTemplate;

    public RabbitmqPublish(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendSimpleMsg(String message) {
        rabbitTemplate.convertAndSend(RabbitConfig.SIMPLE_QUEUE_NAME, message);
    }

    public void sendDelayMsg(Article article, int delay) {
        // 这里routingKey指定了不会生效，fanout类型会广播给所有订阅者
        rabbitTemplate.convertAndSend(RabbitConfig.DELAY_EXCHANGE, "", article, message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            message.getMessageProperties().setDelay(delay * 1000);   // 毫秒为单位，指定此消息的延时时长
            return message;
        });
    }
}
