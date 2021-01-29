package com.study.nacos.controller;

import com.study.nacos.api.ClientApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateController
 * @author JIAYUTAO
 * @create 2021-01-27 15:29
 * @desc
 * 使用RestTemplate进行服务调用
 **/
@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private ClientApi clientApi;

    @GetMapping("/test")
    public String test() {
        String didi = clientApi.hello("didi");
        return didi;
    }


}