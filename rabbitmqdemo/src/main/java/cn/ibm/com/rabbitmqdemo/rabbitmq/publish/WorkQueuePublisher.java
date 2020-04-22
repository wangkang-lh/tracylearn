package cn.ibm.com.rabbitmqdemo.rabbitmq.publish;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = "cn.ibm.com.rabbitmqdemo.rabbitmq.publish")
@EnableScheduling
@Profile("publish")*/
public class WorkQueuePublisher {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    AtomicInteger count = new AtomicInteger();

    @Scheduled(fixedDelay = 500)
    public void send() {
        String message = "Hello Tracy!" + count.incrementAndGet();
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WorkQueuePublisher.class, args);
        System.in.read();
    }
}
