package cn.ibm.com.rabbitmqdemo.rabbitmq.publish;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class WorkQueueConfig {

    @Bean
    public SimpleRabbitListenerContainerFactory mqFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                              ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        // factory.setMessageConverter(myMessageConverter());
        factory.setPrefetchCount(20);
        return factory;
    }

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
}
