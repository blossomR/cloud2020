package com.blossom.springcloud.service.impl;

import com.blossom.springcloud.service.FutureService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class FutureServiceImpl implements FutureService {

    @Override
    public CompletableFuture<String> get() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "(surprise m*therf**ker !)";
        });
    }
}
