package com.trau.study.mapper;

import com.trau.study.model.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component("userMapper")
public interface UserMapper {

    int insertUserById(user u1);

    //用户根据姓名密码登录
    user queryUserById(@Param("uName") String uName,@Param("uPassword") String uPassword);

    //根据用户id查询用户
    user queryUserByid(String uId);
}
