package cn.ibm.com.demo.rabbitmq.consumer1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;

//@Configuration
public class WorkQueueConfig {

    @Bean
    public SimpleRabbitListenerContainerFactory mqFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                          ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        // factory.setMessageConverter(myMessageConverter());
        factory.setPrefetchCount(2);
        return factory;
    }

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
}
