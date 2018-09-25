package com.springboot.controller.interceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunshine on 2018/9/25.
 */
@RestController
@RequestMapping(value = "/two")
public class TwoController {

    @RequestMapping(value = "/test1")
    public String hello2(){
        return "hello world 1";
    }
}
