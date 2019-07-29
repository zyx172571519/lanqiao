package com.trau.study.controller;

import com.trau.study.model.student;
import com.trau.study.model.user;
import com.trau.study.service.UserService;
import com.trau.study.utils.Constant;
import com.trau.study.utils.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    //注册用户
    @RequestMapping("/insert/id")
    @ResponseBody
    public Object insertUserById(user u1){
        JsonResult result = null;
        try {
            int u2 = userService.insertUserById(u1);
            logger.info("查询{}");
            result = new JsonResult("查询成功", Constant.STATUC_SUCCESS, u2);
        } catch (Exception ex) {
            logger.info(ex.getMessage());
            result = new JsonResult("查询异常", Constant.STATUC_FAILURE);
        }
        return result;
    }

    //用户登录
    @RequestMapping("/query/login")
    @ResponseBody
    public Object queryUserById(@Param("uName") String uName,@Param("uPassword") String uPassword){
        JsonResult result = null;
        try {
            user u1 = userService.queryUserById(uName,uPassword);
            logger.info("查询{}");
            result = new JsonResult("查询成功", Constant.STATUC_SUCCESS, u1);
        } catch (Exception ex) {
            logger.info(ex.getMessage());
            result = new JsonResult("查询异常", Constant.STATUC_FAILURE);
        }
        return result;
    }

    @RequestMapping("/query/user/id")
    @ResponseBody
    public Object queryUserByid(String uId){
        JsonResult result=null;
        try {
            user u2 = userService.queryUserByid(uId);
            logger.info("查询{}");
            result = new JsonResult("查询成功", Constant.STATUC_SUCCESS, u2);
        } catch (Exception ex) {
            logger.info(ex.getMessage());
            result = new JsonResult("查询异常", Constant.STATUC_FAILURE);
        }
        return result;
    }

}
