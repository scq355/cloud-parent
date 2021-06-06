package com.cloud.feignhystrix.controller;

import com.cloud.feignhystrix.client.HystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author scq
 */
@RestController
public class InvokeHystrixController {

    @Qualifier("com.cloud.feignhystrix.client.HystrixClient")
    @Autowired
    private HystrixClient hystrixClient;

    @GetMapping(value = "invoke")
    public String invoke() {
        String demo = hystrixClient.demo(-1);
        System.out.println("invoke ok=" + demo);
        return "invoke ok=" + demo;
    }
}
