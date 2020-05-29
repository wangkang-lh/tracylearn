package com.ibm.cn.demozuul.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("noAuth.zuul.token-filter")
@Data
public class NoAuthConfigurationBean {
    //Route URI without authentication
    private List<String> noAuthoutes;
}
