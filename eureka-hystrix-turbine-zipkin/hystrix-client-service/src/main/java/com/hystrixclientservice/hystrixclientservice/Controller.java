package com.hystrixclientservice.hystrixclientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired private Service service;

    @RequestMapping("")
    public String hello() throws Exception {
        return service.hello();
    }
}
