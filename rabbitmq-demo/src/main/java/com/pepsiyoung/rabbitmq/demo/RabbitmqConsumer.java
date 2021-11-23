package com.pepsiyoung.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 消费者
 */
@Component
@Slf4j
public class RabbitmqConsumer {

    @RabbitListener(queues = RabbitConfig.SIMPLE_QUEUE_NAME)
    @RabbitHandler
    public void consumerSimpleMessage(@Payload String message) {
        log.info("simple队列的内容:{}", message);
    }

    //消费延时消息
    @RabbitListener(queues = RabbitConfig.DELAY_QUEUE_ONE_NAME)
    @RabbitHandler
    public void consumerDelayOneMessage(@Payload Article article) throws IOException {
        log.info("延迟队列ONE 标题:{} 作者:{} 内容:{}",
                article.getTitle(), article.getAuthor(), article.getContent());
    }

    @RabbitListener(queues = RabbitConfig.DELAY_QUEUE_TWO_NAME)
    public void consumerDelayTWOMessage(Article article, Message message, Channel channel) {
        log.info("延迟队列TWO 标题:{} 作者:{} 内容:{}",
                article.getTitle(), article.getAuthor(), article.getContent());
    }
}
