package com.ibm.cn.demoprovider.configruration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Tracy
 * @date 2020/5/25 23:09
 */
@Configuration
class AcessConfig implements WebMvcConfigurer {

    @Autowired
    private LoginingInterceptor loginingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginingInterceptor).addPathPatterns("/**");
    }
}
