package com.study.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName SpringApplicationStart
 * @author JIAYUTAO
 * @create 2021-01-27 10:06
 * @desc
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ServerStartApp {

    public static void main(String[] args) {
        SpringApplication.run(ServerStartApp.class, args);
    }


}