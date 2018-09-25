package com.springboot.controller;

import com.springboot.pojo.JsonResult;
import com.springboot.pojo.SysUser;
import com.springboot.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by sunshine on 2018/9/20.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping(value="/get")
    @ResponseBody
    public JsonResult getUser(){
        SysUser user=new SysUser();
        String userId=sid.nextShort();
        user.setId(userId);
        user.setName("zj张");
        user.setAge(12);
        user.setBirthday(new Date());
        userService.add(user);
        return JsonResult.ok(user);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public JsonResult deleteUser(){
        userService.delete("180920C5RT121968");
        return JsonResult.ok();
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public JsonResult updateUser(){
        SysUser user=new SysUser();
        user.setId("180921819F7R3C94");
        user.setName("lalala");
        userService.update(user);
        return JsonResult.ok();
    }

    @RequestMapping(value="/getById")
    @ResponseBody
    public JsonResult getId(){
        SysUser user=userService.findById("180921819HN3XDD4");
        return JsonResult.ok(user);
    }

    @RequestMapping(value="/queryByPage")
    @ResponseBody
    public JsonResult getId(Integer page){
        if(page==null){
            page=1;
        }
        Integer pageSize=5;
        SysUser sysUser=new SysUser();
        List<SysUser> userList=userService.findByPaged(sysUser,page,pageSize);
        return JsonResult.ok(userList);
    }

    @RequestMapping(value="/queryById")
    @ResponseBody
    public JsonResult getId(String id){
        if(id==null){
            return JsonResult.errorException("用户id为空");
        }
        SysUser user=userService.queryById(id);
        return JsonResult.ok(user);
    }

    @RequestMapping(value="/saveTransactional")
    @ResponseBody
    public JsonResult saveUser(){
        SysUser user=new SysUser();
        String id=sid.nextShort();
        user.setId(id);
        user.setName("hello");
        user.setAge(15);
        user.setBirthday(new Date());
        userService.saveByTransaction(user);
        return JsonResult.ok(user);
    }


}
