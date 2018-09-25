package com.springboot.controller;

import com.springboot.pojo.JsonResult;
import com.springboot.pojo.Resource;
import com.springboot.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author  sunshine on 2018/9/19.
 */
@Controller
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping(value="/hello")
    public String hello(){
        return "我想知道你想干嘛";
    }

    @RequestMapping(value="/user")
    public JsonResult user(){
        User user=new User(111,"z111",201,new Date(),"这个人是个帅哥");
        return JsonResult.ok(user);
    }

    @RequestMapping(value="/resource")
    public JsonResult resource(){
        Resource resource1=new Resource();
        BeanUtils.copyProperties(resource,resource1);
        return JsonResult.ok(resource1);
    }

    @RequestMapping(value="/freemarker")
    public String freemaker(ModelMap modelMap){
        modelMap.addAttribute("resource",resource);
        return "/freemarker/center/center";
    }

    @RequestMapping(value="/freemarker1")
    public String freemaker1(ModelMap modelMap){
        modelMap.addAttribute("resource",resource);
        return "/freemarker/index";
    }


}
