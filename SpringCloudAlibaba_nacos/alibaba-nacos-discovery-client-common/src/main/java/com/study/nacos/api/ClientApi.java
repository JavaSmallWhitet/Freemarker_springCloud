package com.study.nacos.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ClientApi
 * @author JIAYUTAO
 * @create 2021-01-27 15:35
 * @desc
 **/

@FeignClient("alibaba-nacos-discovery-server")
public interface ClientApi {

    @GetMapping("/hello")
    public String hello(@RequestParam String name);
}