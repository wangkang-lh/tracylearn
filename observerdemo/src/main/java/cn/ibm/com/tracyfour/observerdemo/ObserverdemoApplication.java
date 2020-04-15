package cn.ibm.com.tracyfour.observerdemo;

import cn.ibm.com.tracyfour.observerdemo.pojo.User;
import cn.ibm.com.tracyfour.observerdemo.service.ObserverInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ObserverdemoApplication implements ApplicationRunner {
    @Autowired
    List<ObserverInterface> list;

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(ObserverdemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //统计实现类
        list.forEach((item) -> {
            System.out.println("实现ObserverInterface的实现类有：" + item.getClass().getSimpleName());
        });
        //发布事件
        context.publishEvent(new User());
    }
}
