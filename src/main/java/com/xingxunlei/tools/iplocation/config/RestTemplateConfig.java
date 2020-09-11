package com.xingxunlei.tools.iplocation.config;

import com.xingxunlei.tools.iplocation.client.SimonRestTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * RestTemplate 配置
 *
 * @author SimonX
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    SimonRestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(3000);

        return new SimonRestTemplate(requestFactory);
    }

}
