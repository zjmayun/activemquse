package com.springboot.mapper;

import com.springboot.pojo.SysUser;
import com.springboot.utils.MyMapper;

public interface SysUserMapperCustom extends MyMapper<SysUser> {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    SysUser queryById(String id);
}