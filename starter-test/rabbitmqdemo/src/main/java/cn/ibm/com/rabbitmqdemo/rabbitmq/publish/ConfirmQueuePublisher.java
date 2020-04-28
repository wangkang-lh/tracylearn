package cn.ibm.com.rabbitmqdemo.rabbitmq.publish;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = "cn.ibm.com.rabbitmqdemo.rabbitmq.publish")
@EnableScheduling
@Profile("publish")
public class ConfirmQueuePublisher {
    @Autowired
    private RabbitTemplate confirmTemplate;

    @Autowired
    private FanoutExchange streamConfirmExchange;

    //消息计数器
    private AtomicInteger count = new AtomicInteger(0);

    // 存放待确认消息的map
    private final Map<String, String> messageMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        this.confirmTemplate.setMandatory(true);
        this.confirmTemplate.setConfirmCallback(confirmCallback());
        this.confirmTemplate.setReturnCallback(returnCallback());
    }


    @Scheduled(fixedDelay = 1000)
    public void send() {
        String message = "hello tracy" + count.incrementAndGet();
        String id = "id-" + count.get();
        CorrelationData correlationData = new CorrelationData(id);
        messageMap.put(id, message);
        this.confirmTemplate.convertAndSend(streamConfirmExchange.getName(), "routingkeyaaa", message, correlationData);
        System.out.println(" [tracy] Sent '" + message + "'");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConfirmQueuePublisher.class, args);
        System.in.read();
    }

    // 创建ConfirmCallback实例的方法
    private RabbitTemplate.ConfirmCallback confirmCallback() {
        return new RabbitTemplate.ConfirmCallback() {
            @Override
            // correlationData 发布消息时指定的关联数据
            // ack is true for an ack and false for a nack
            // cause nack的原因
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) { // 确认成功
                    System.out.println(" publish successful");
                } else { // 确认失败
                    System.out.println(" publish fail");
                    System.out.println("the failed reason is" + cause + ", the correlationId is" + correlationData.getId());
                }
                // 根据关联数据的id从待确认消息Map中移除消息
                System.out.println("the removed message is " + messageMap.remove(correlationData.getId()));
            }
        };
    }

    private RabbitTemplate.ReturnCallback returnCallback() {
        return new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("miss queue message is " + message.getMessageProperties().getCorrelationId());
            }
        };
    }
}
