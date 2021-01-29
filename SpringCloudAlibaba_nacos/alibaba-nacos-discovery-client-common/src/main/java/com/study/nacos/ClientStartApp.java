package com.study.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName AlibabaNacosDiscoveryClientCommon
 * @author JIAYUTAO
 * @create 2021-01-27 11:17
 * @desc
 * https://blog.didispace.com/spring-cloud-alibaba-1/
 * https://blog.didispace.com/spring-cloud-alibaba-2/
 **/
@EnableFeignClients     //开启feign远程调用配置
@EnableDiscoveryClient  //开启注册中心配置
@SpringBootApplication
public class ClientStartApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientStartApp.class, args);
    }

    //注入一个RestTemplate对象到容器中
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}