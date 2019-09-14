package com.zk.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhengKai
 * @data 2019-09-08 23:18
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {

        // 第一种方式
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:10001/msg",String.class);
//        log.info("response = {}",response);
//        return response;

        // 第二种方式
//        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s/msg",serviceInstance.getHost(),serviceInstance.getPort());
//        String response = restTemplate.getForObject(url,String.class);
//        log.info("respnse = {}",response);
//        return response;
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response = {}", response);
        return response;
    }
}
