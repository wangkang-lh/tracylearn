package cn.ibm.com.demo.rabbitmq.publish;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = "cn.ibm.com.rabbitmqdemo.rabbitmq.publish")
@EnableScheduling
@Profile("publish")*/
public class DirectQueuePublisher {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    AtomicInteger count = new AtomicInteger(0);

    String[] routingKeys = {"orange", "green"};

    @Scheduled(fixedDelay = 1000)
    public void send() {
        int i = count.incrementAndGet();
        String message = "routing message-" + i + " routingKey=" + routingKeys[i % 2];
        template.convertAndSend(direct.getName(), routingKeys[i % 2], message);
        System.out.println(" [tracy] Sent '" + message + "'");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DirectQueuePublisher.class, args);
        System.in.read();
    }
}
