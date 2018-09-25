package com.springboot.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author  by sunshine on 2018/9/20.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
