package com.trau.study.service.Impl;

import com.trau.study.mapper.UserMapper;
import com.trau.study.model.user;
import com.trau.study.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    //注册用户
    @Override
    public int insertUserById(user u1) {
        int user1=userMapper.insertUserById(u1);
        return user1;
    }

    //用户登录
    @Override
    public user queryUserById(String uName,String uPassword) {
        user u = userMapper.queryUserById(uName,uPassword);
        return u;
    }

    //根据用户ID查询用户详情
    @Override
    public user queryUserByid(String uId) {
        user u2=userMapper.queryUserByid(uId);
        return u2;
    }
}
