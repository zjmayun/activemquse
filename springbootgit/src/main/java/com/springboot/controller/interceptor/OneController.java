package com.springboot.controller.interceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunshine on 2018/9/25.
 */
@RestController
@RequestMapping(value = "/one")
public class OneController {

    @RequestMapping(value = "/test1")
    public String hello(){
        System.out.println("gogogogo one interceptor");
        return "hello world";
    }
}
