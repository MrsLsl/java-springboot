package com.example.javaspringboot.springboot.rabbitmq;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * 接受者
 *
 * @Author: Liusl
 * @Date: 2020/3/31 16:27
 */
@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
