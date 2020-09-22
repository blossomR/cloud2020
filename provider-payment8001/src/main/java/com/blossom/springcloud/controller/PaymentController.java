package com.blossom.springcloud.controller;

import com.blossom.springcloud.entity.CommonResult;
import com.blossom.springcloud.entity.Payment;
import com.blossom.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@SuppressWarnings("unchecked")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：{}", result);
        if (result > 0) {
            return new CommonResult(200, "insert successfully, serverPort：" + serverPort, result);
        }
        return new CommonResult(-1, "insert failed, serverPort：" + serverPort, null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymengById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：{}", result);
        if (result != null) {
            return new CommonResult(200, "query successfully, serverPort：" + serverPort, result);
        }
        return new CommonResult(-1, "no records ,id = " + id + ", serverPort：" + serverPort, result);
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("===== element: {} ======", element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

}
