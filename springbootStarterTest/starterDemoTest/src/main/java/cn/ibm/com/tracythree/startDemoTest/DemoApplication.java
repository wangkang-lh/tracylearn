package cn.ibm.com.tracythree.startDemoTest;

import cn.ibm.com.tracyone.commonService.Commonservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);
        SpringApplication context = new SpringApplication(DemoApplication.class);
        ConfigurableApplicationContext configurableApplicationContext = context.run(args);
        Commonservice commonservice = (Commonservice) configurableApplicationContext.getBean("commonservice");
        commonservice.service();
    }
}
