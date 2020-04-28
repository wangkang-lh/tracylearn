package cn.ibm.com.rabbitmqdemo.rabbitmq.consumer1;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfirmConfig {
    @Bean
    public FanoutExchange streamConfirmExchange() {
        return new FanoutExchange("stream-confirm-exchange");
    }

    @Bean
    public Queue streamConfirmQueue() {
        return new Queue("streamConfirmQueue");
    }

    @Bean
    public Binding bind(FanoutExchange fanoutExchange, Queue streamConfirmQueue) {
        return BindingBuilder.bind(streamConfirmQueue).to(fanoutExchange);
    }
}

