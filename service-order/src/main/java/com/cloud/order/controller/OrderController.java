package com.cloud.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchangqing
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Value("${server.port}")
    private int port;

    @GetMapping
    public String demo() {
        System.out.println("demo order ok");
        return "demo order ok, 当前提供服务端口=" + port;
    }
}
