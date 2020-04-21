package cn.ibm.com.rabbitmqdemo.rabbitmq.publish;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
public class DirectConfig {
    @Bean
    public DirectExchange direct() {
        return new DirectExchange("spring.routing");
    }

    @Bean
    public Queue queue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue queue2() {
        return new AnonymousQueue();
    }

    @Bean
    @ConditionalOnBean(value = {Queue.class, DirectExchange.class})
    public Binding bind1(DirectExchange direct, Queue queue1) {
        return BindingBuilder.bind(queue1).to(direct).with("orange");
    }

    @Bean
    @ConditionalOnBean(value = {Queue.class, DirectExchange.class})
    public Binding bind2(DirectExchange direct, Queue queue2) {
        return BindingBuilder.bind(queue2).to(direct).with("green");
    }
}

