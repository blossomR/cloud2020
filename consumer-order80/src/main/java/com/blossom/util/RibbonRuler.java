package com.blossom.util;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRuler {

    @Bean
    public IRule myRuler() {
        // 自定义为随机
        return new RandomRule();
    }
}
