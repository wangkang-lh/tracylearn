package cn.ibm.com.demo.rabbitmq.consumer1;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = "cn.ibm.com.rabbitmqdemo.rabbitmq.consumer1")
@Profile("consumer1")*/
public class WorkQueueConsumer1 {

    @RabbitListener(queues = "hello", containerFactory = "mqFactory", concurrency = "2-5")
    public void receive(Channel channel, String in) {
        System.out.println("this is consumer1");
        System.out.println("Channel-" + channel.getChannelNumber() + " Received '" + in + "'");
    }

    /*public static void main(String[] args) throws Exception {
        SpringApplication.run(WorkQueueConsumer1.class, args);
        System.in.read();
    }*/
}
