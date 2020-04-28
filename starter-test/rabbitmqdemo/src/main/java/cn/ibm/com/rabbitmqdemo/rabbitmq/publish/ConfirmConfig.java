package cn.ibm.com.rabbitmqdemo.rabbitmq.publish;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfirmConfig {
    @Bean
    public FanoutExchange streamConfirmExchange() {
        return new FanoutExchange("stream-confirm-exchange");
    }
}

