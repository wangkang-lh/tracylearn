package cn.ibm.com.tracythree.demotest;

import cn.ibm.com.tracyone.commonstarter.Commonservice;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(ServiceProperties.class)
public class ServiceAutoConfigure {
    @Bean
    public Commonservice commonservice(ServiceProperties sp) {
        Commonservice commonservice = new Commonservice();
        commonservice.setName(sp.getName());
        commonservice.setSex(sp.getSex());
        return commonservice;
    }
}
