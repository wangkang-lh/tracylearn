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
public class StreamConfirmConsumer {

    @RabbitListener(queues = "streamConfirmQueue")
    public void receive(Channel channel, String in) {
        System.out.println("this is stream consumer");
        System.out.println("Channel-" + channel.getChannelNumber() + " Received '" + in + "'");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StreamConfirmConsumer.class, args);
        System.in.read();
    }
}
