package com.blossom.springcloud.service;

import com.blossom.springcloud.entity.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
