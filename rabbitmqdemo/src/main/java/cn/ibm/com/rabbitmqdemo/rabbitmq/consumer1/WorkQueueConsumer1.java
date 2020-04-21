package cn.ibm.com.rabbitmqdemo.rabbitmq.consumer1;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
scanBasePackages = "cn.ibm.com.rabbitmqdemo.rabbitmq.consumer1")
@Profile("consumer1")
public class WorkQueueConsumer1 {

    @RabbitListener(queues = "hello", concurrency = "2", containerFactory = "mqFactory") // 并发2到5个消费者
    public void receive(Channel channel, String in) {
		System.out.println("this is consumer1");
        System.out.println("Channel-" + channel.getChannelNumber() + " Received '" + in + "'");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WorkQueueConsumer1.class, args);
        System.in.read();
    }
}
