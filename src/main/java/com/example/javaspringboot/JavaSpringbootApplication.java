package com.example.javaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootApplication
@ComponentScan("com.example.javaspringboot")
public class JavaSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringbootApplication.class, args);
    }

}
