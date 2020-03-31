package com.example.javaspringboot.springboot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 发布者（publisher）发布消息
 *
 * @Author: Liusl
 * @Date: 2020/3/31 16:32
 */
@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(RabbitMqConfig.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        receiver.getLatch().await(1, TimeUnit.MINUTES);
    }
}
