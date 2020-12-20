package com.blossom.springcloud.service;

import java.util.concurrent.CompletableFuture;

public interface FutureService {

     CompletableFuture<String> get();

}
