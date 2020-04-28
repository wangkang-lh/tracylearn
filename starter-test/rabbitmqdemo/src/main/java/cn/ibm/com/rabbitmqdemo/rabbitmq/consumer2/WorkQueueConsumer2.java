package cn.ibm.com.rabbitmqdemo.rabbitmq.consumer2;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = "cn.ibm.com.rabbitmqdemo.rabbitmq.consumer2")
@Profile("consumer2")*/
public class WorkQueueConsumer2 {

    @RabbitListener(queues = "hello", containerFactory = "mqFactory", concurrency = "2-5")
    public void receive(Channel channel, String in) {
        System.out.println("this is consumer2");
        try {
            //模拟阻塞
            System.out.println("I'm waiting");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Channel-" + channel.getChannelNumber() + " Received '" + in + "'");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WorkQueueConsumer2.class, args);
        System.in.read();
    }
}
