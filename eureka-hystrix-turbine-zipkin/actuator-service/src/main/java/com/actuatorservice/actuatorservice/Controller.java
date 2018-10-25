package com.actuatorservice.actuatorservice;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
public class Controller {

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }
}
