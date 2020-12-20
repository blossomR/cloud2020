package com.blossom.springcloud.controller;

import com.blossom.springcloud.entity.CommonResult;
import com.blossom.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@RestController
@SuppressWarnings("unchecked")
public class OthersController {

    // zookeeper注册名
    private static final String INVOKE_URL = "http://provider-zk-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/future/get")
    public CompletableFuture create() {
        CompletableFuture future =  restTemplate.postForObject(INVOKE_URL + "/future/get", null, CompletableFuture.class);
        return null;
    }
}
