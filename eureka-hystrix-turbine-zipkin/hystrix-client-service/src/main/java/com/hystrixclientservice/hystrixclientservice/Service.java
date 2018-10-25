package com.hystrixclientservice.hystrixclientservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Component
public class Service {

    @HystrixCommand(fallbackMethod = "fallbackHello")
    public String hello() throws Exception {
        if(Math.random() < 0.5){
            throw new Exception();
        }
        return "Hello";
    }

    private String fallbackHello() {
        return "Fallback Hello";
    }
}
