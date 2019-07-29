package com.trau.study.mapper;

import com.trau.study.model.student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("StudentMapper")
public interface StudentMapper {

    student queryStudentById(String newId);

    List<student> queryAllById();

    int  deleteStudentById(String newId);
}
