package com.trau.study.service.Impl;

import com.trau.study.mapper.StudentMapper;
import com.trau.study.model.student;
import com.trau.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public student queryStudentById(String newId) {
        student stu=studentMapper.queryStudentById(newId);
        return stu;
    }

    @Override
    public List<student> queryAllById() {
        List<student> articleList = studentMapper.queryAllById();
        return articleList;
    }

    @Override
    public int deleteStudentById(String newId) {
        int i=studentMapper.deleteStudentById(newId);
        return i;
    }
}
