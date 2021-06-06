package com.cloud.user.controller;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sunchangqing
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 服务注册与发现客户端对象
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping
    public String invoke() {
//        System.out.println("user invoke");
//        RestTemplate restTemplate = new RestTemplate();
//        String orderResult = restTemplate.getForObject("http://" + randomHost() + "/order", String.class);
//        return "user invoke ok, invoke result is: " + orderResult;

//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("SERVICE-ORDER");
//        serviceInstanceList.forEach(serviceInstance -> {
//            System.out.println(serviceInstance.getInstanceId()
//                    + " " + serviceInstance.getHost()
//                    + " " + serviceInstance.getPort()
//                    + " " + serviceInstance.getUri());
//        });
//        String result = new RestTemplate().getForObject(serviceInstanceList.get(0).getUri() + "/order", String.class);


//        ServiceInstance serviceInstance = loadBalancerClient.choose("SERVICE-ORDER");
//        System.out.println(serviceInstance.getInstanceId()
//                    + " " + serviceInstance.getHost()
//                    + " " + serviceInstance.getPort()
//                    + " " + serviceInstance.getUri());
//        String result = restTemplate.getForObject(serviceInstance.getUri() + "/order", String.class);


        String result = restTemplate.getForObject("http://SERVICE-ORDER/order", String.class);

        return "ok: " + result;
    }

    /**
     * 随机路由策略
     * 无法实现服务健康检查，负载均衡策略过于单一
     *
     * @return
     */
    public String randomHost() {
        ArrayList<String> list = new ArrayList<>();
        list.add("localhost:9991");
        list.add("localhost:8882");
        return list.get(new Random().nextInt(list.size()));
    }
}
