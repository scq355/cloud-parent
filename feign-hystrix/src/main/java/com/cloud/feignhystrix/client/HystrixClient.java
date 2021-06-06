package com.cloud.feignhystrix.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author scq
 */
@FeignClient(value = "CLOUD-HYSTRIX", fallback = HystrixClientFallBack.class)
public interface HystrixClient {

    @GetMapping(value = "demo")
    String demo(@RequestParam(value = "id") Integer id);
}
