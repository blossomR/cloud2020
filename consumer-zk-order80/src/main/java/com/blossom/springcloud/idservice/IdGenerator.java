package com.blossom.springcloud.idservice;

import com.blossom.springcloud.config.IdUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IdGenerator {

    @Resource(name = "impl")
    private IdClient idClient;



    public Long idGen(){
        return IdUtil.nextId();
    }

}
