package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient client;

    @Qualifier("eurekaRegistration")
    @Autowired
    private Registration registration;

    @GetMapping("/info")
    public String info() {
        @SuppressWarnings("deprecation")
        String info = "host：" + registration.getHost() + "，service_id：" + registration.getServiceId();
        log.info(info);
        return info;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
