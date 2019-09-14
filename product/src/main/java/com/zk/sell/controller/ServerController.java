package com.zk.sell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhengKai
 * @data 2019-09-08 23:13
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is sell' message";
    }
}
