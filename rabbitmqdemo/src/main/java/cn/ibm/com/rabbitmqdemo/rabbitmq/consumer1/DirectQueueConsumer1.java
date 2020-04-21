package cn.ibm.com.rabbitmqdemo.rabbitmq.consumer1;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = "cn.ibm.com.rabbitmqdemo.rabbitmq.consumer1")
@Profile("consumer1")
public class DirectQueueConsumer1 {

    @RabbitListener(queues = "#{queue1.name}")
    public void receive(Channel channel, String in) {
        System.out.println("this is consumer1");
        System.out.println("Channel-" + channel.getChannelNumber() + " Received '" + in + "'");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DirectQueueConsumer1.class, args);
        System.in.read();
    }
}
