package com.trau.study.service;

import com.trau.study.model.user;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    int insertUserById(user u1);

    //根据用户名、密码登录
    user queryUserById(@Param("uName") String uName,@Param("uPassword") String uPassword);

    //根据用户id查询用户
    user queryUserByid(String uId);
}
