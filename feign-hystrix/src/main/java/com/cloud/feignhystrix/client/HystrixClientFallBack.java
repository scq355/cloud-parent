package com.cloud.feignhystrix.client;

import org.springframework.stereotype.Component;

/**
 * @author scq
 */
@Component
public class HystrixClientFallBack implements HystrixClient {
    @Override
    public String demo(Integer id) {
        return "当前服务不可用，稍后再试" + id;
    }
}
