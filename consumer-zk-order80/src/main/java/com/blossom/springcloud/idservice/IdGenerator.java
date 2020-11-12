package com.blossom.springcloud.idservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IdGenerator {

    @Resource(name = "impl")
    private IdClient idClient;

    public long idGen(){
        return idClient.nextId();
    }

}
