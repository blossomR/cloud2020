package com.blossom.springcloud.mapper;

import com.blossom.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    int create(@Param("payment") Payment payment);

    Payment getPaymentById(@Param("id") Long id);


}
