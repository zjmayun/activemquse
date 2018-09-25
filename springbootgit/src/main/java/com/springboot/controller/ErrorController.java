package com.springboot.controller;

import com.springboot.pojo.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author by sunshine on 2018/9/19.
 */
@Controller
@RequestMapping(value="/error")
public class ErrorController {

    @RequestMapping(value = "/test")
    public String error(){
        int i=5/0;
        return "thymeleaf/error";
    }

    @RequestMapping(value = "/test1")
    public String errorshow(){

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping(value = "/getAjaxerror")
    @ResponseBody
    public JsonResult ajaxError(){
        System.out.println("hello");
        int i=5/0;
        return JsonResult.ok();
    }

}
