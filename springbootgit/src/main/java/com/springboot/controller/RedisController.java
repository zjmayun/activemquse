package com.springboot.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.pojo.JsonResult;
import com.springboot.pojo.SysUser;
import com.springboot.utils.JsonUtils;
import com.springboot.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunshine on 2018/9/21.
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisOperator redisOperator;

    @RequestMapping(value = "/test")
    public JsonResult test(){
        redisTemplate.opsForValue().set("name","zj");
        SysUser user=new SysUser();
        user.setId("1111111");
        user.setName("zj张");
        user.setAge(12);
        user.setBirthday(new Date());
        redisTemplate.opsForValue().set("user1", JsonUtils.objectToJson(user));
        //先取出数据，然后转化成pojo，也就是object的格式
        SysUser sysUser=JsonUtils.jsonToPojo(redisTemplate.opsForValue().get("user1"),SysUser.class);

        return JsonResult.ok(redisTemplate.opsForValue().get("name"));
    }


    @RequestMapping(value = "/getJsonList")
    public JsonResult test1(){
        List<SysUser> list=new ArrayList<>();
        SysUser user=new SysUser();
        user.setId("1111111");
        user.setName("zj张");
        user.setAge(12);
        user.setBirthday(new Date());

        SysUser user1=new SysUser();
        user1.setId("2222222");
        user1.setName("zj张2");
        user1.setAge(22);
        user1.setBirthday(new Date());

        SysUser user3=new SysUser();
        user3.setId("333333");
        user3.setName("zj张3");
        user3.setAge(33);
        user3.setBirthday(new Date());

        list.add(user);
        list.add(user1);
        list.add(user3);
        redisOperator.set("user:list1",JsonUtils.objectToJson(list));
        String userList=redisOperator.get("user:list1");
        List<SysUser> list1=JsonUtils.jsonToList(userList,SysUser.class);
        return JsonResult.ok(list1);
    }

}














