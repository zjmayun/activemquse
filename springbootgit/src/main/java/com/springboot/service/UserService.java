package com.springboot.service;

import com.springboot.pojo.SysUser;

import java.util.List;

/**
 * Created by sunshine on 2018/9/20.
 */
public interface UserService {
    boolean add(SysUser user);

    boolean update(SysUser user);

    boolean delete(String id);

    SysUser findById(String id);

    List<SysUser> findByList();

    List<SysUser> findByPaged(SysUser sysUser,Integer page,Integer pageSize);

    SysUser queryById(String id);

    //添加了一个事务进行处理
    boolean saveByTransaction(SysUser user);
}
