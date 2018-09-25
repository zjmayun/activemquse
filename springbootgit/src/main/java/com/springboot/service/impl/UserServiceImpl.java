package com.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.springboot.mapper.SysUserMapper;
import com.springboot.mapper.SysUserMapperCustom;
import com.springboot.pojo.SysUser;
import com.springboot.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by sunshine on 2018/9/20.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserMapperCustom mapperCustom;

    @Override
    public boolean add(SysUser user) {
         int i=userMapper.insert(user);
         return i==1;
    }

    @Override
    public boolean update(SysUser user) {
        int i=userMapper.updateByPrimaryKeySelective(user);
        return i==1;
    }

    @Override
    public boolean delete(String id) {
        int i=userMapper.deleteByPrimaryKey(id);
        return i==1;
    }

    @Override
    public SysUser findById(String id) {
        SysUser user=userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<SysUser> findByList() {
        return null;
    }

    /**
     * 这个分页查询不得了啊
     * @param sysUser
     * @param page
     * @param pageSize
     * @return
     */
    public List<SysUser> findByPaged(SysUser sysUser,Integer page,Integer pageSize){
        PageHelper.startPage(page,pageSize);
        Example example=new Example(SysUser.class);
        Example.Criteria criteria=example.createCriteria();
        if(sysUser.getName()!=null&&!sysUser.getName().equals("")){
            criteria.andLike("name","%"+sysUser.getName()+"%");
        }
        example.orderBy("birthday").desc();
        return userMapper.selectByExample(example);
    }

    public SysUser queryById(String id){
        return  mapperCustom.queryById(id);
    }

    /**
     * 按照事务来进行执行
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveByTransaction(SysUser user){
        userMapper.insert(user);
        int i=5/0;
        user.setName("俊帅来咯");
        int j=userMapper.updateByPrimaryKeySelective(user);
        return j==1;
    }
}
