package com.trau.study.controller;

import com.trau.study.model.student;
import com.trau.study.service.StudentService;
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

import java.util.List;

@Controller
@CrossOrigin
public class StudentController {
    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    //根据id查询文章
    @RequestMapping("/query/news/id")
    @ResponseBody
    public Object queryStudentById(String newId) {
        System.out.println(newId);
        JsonResult result = null;
        try {
            student stu = studentService.queryStudentById(newId);
            logger.info("查询{}", newId);
            result = new JsonResult("查询成功", Constant.STATUC_SUCCESS, stu);
        } catch (Exception ex) {
            logger.info(ex.getMessage());
            result = new JsonResult("查询异常", Constant.STATUC_FAILURE);
        }
        return result;
    }

    //查询全部文章
    @RequestMapping("/query/news")
    @ResponseBody
    public Object queryArticle() {
        JsonResult result = null;
        try {
            List<student> articleList = studentService.queryAllById();
            logger.info("查询{}{}");
            result = new JsonResult("查询成功", Constant.STATUC_SUCCESS, articleList);
        } catch (Exception ex) {
            logger.info(ex.getMessage());
            result = new JsonResult("查询异常", Constant.STATUC_FAILURE);
        }
        return result;
    }

    //根据文章id删除文章
    @RequestMapping("delete/id")
    @ResponseBody
    public int deleteStudentById(String newId){
        JsonResult result=null;
        int i=0;
        try {
            i = studentService.deleteStudentById(newId);
            logger.info("删除{}");
            result = new JsonResult("查询成功", Constant.STATUC_SUCCESS, i);
        }catch(Exception ex){
            logger.info(ex.getMessage());
            result=new JsonResult("查询异常",Constant.STATUC_FAILURE);
        }
        return i;
    }


}
