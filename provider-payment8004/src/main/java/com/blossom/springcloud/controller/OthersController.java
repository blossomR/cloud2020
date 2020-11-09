package com.blossom.springcloud.controller;

import com.blossom.springcloud.service.FutureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@SuppressWarnings("unchecked")
public class OthersController {
    @Resource
    private FutureService futureService;

    @RequestMapping("/future/get")
    public CompletableFuture getFutureTask() {
        long start = System.currentTimeMillis();
        CompletableFuture<String> result = futureService.get();
        long end = System.currentTimeMillis();
        long duration = end-start;
        log.info("process duration is "+duration+" ms");
        return result;
    }
}
