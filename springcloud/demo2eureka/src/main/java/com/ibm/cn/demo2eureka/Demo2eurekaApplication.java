package com.ibm.cn.demo2eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Demo2eurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo2eurekaApplication.class, args);
    }

}
