package com.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author scq
 */
@RefreshScope
@RestController
public class IndexController {

    @Value("${name}")
    private String name;

    @GetMapping("index")
    public String index() {
        return "index ok" + name;
    }
}
