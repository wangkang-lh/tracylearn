package cn.ibm.com.demo.rabbitmq.consumer1;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;

/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = "cn.ibm.com.rabbitmqdemo.rabbitmq.consumer1")
@Profile("consumer1")*/
public class DirectQueueConsumer1 {

    @RabbitListener(queues = "queue1", priority = "1000")
    public void receive(Channel channel, String in) {
        System.out.println("this is consumer1");
        System.out.println("Channel-" + channel.getChannelNumber() + " Received '" + in + "'" + System.nanoTime());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DirectQueueConsumer1.class, args);
        System.in.read();
    }
}
