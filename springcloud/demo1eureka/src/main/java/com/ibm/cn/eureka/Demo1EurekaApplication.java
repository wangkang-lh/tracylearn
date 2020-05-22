package com.ibm.cn.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Demo1EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo1EurekaApplication.class, args);
    }

}
