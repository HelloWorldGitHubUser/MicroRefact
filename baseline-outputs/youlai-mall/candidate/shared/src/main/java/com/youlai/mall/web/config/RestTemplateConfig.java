package com.youlai.mall.web.config;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemplateConfig {


@Bean
public RestTemplate restTemplate(ClientHttpRequestFactory simpleClientHttpRequestFactory){
    return new RestTemplate(simpleClientHttpRequestFactory);
}


@Bean
public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
    // 单位 ms
    factory.setReadTimeout(5000);
    // 单位 ms
    factory.setConnectTimeout(5000);
    return factory;
}


}