package com.cloud.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author scq
 */
@RestController
public class DemoController {

    @GetMapping(value = "demo")
    @HystrixCommand(fallbackMethod = "demoFallBack", defaultFallback = "defaultFallback")
    public String demo(Integer id) {
        if (id <= 0) {
            throw new RuntimeException("demo exception");
        }
        System.out.println("demo ok");
        return "demo ok" + id;
    }

    public String defaultFallback() {
        return "demo 服务不可用";
    }

    public String demoFallBack(Integer id) {
        return "demo 服务已被熔断" + id;
    }
}
