package com.blossom.springcloud.controller;

import com.blossom.springcloud.entity.CommonResult;
import com.blossom.springcloud.entity.Payment;
import com.blossom.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：{}", result);
        if (result > 0) {
            return new CommonResult(200, "insert successfully", result);
        }
        return new CommonResult(-1, "insert failed", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymengById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：{}", result);
        if (result != null) {
            return new CommonResult(200, "query successfully", result);
        }
        return new CommonResult(-1, "no records ,id = " + id, result);
    }

}
