package com.blossom.springcloud.dao;

import com.blossom.springcloud.entity.Payment;
import com.blossom.springcloud.mapper.PaymentMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PaymentDao {
    @Resource
    private PaymentMapper paymentMapper;

    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

}
