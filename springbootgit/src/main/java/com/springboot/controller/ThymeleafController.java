package com.springboot.controller;

import com.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author  sunshine on 2018/9/19.
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/thymeleaf")
    public String thymeleaf(ModelMap modelMap){
        modelMap.addAttribute("name","helloworld1");
        return "thymeleaf/index";
    }

    @RequestMapping("/thymeleaf1")
    public String thymeleaf1(ModelMap modelMap){
        User user=new User(1,"manager",15,new Date(),"hello world");
        modelMap.addAttribute("user",user);
        return "thymeleaf/test";
    }

}
