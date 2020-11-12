package com.blossom.springcloud.config;

import com.blossom.springcloud.idservice.IdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdUtil {

    private static IdClient ID_CLIENT;

//    @Autowired
//    public void setIdCleint(){
//
//    }

    public static Long nextId(){
        return ID_CLIENT.nextId();
    }


}
