package com.trau.study.service;

import com.trau.study.model.student;

import java.util.List;

public interface StudentService {

    student queryStudentById(String newId);

    List<student> queryAllById();

    int deleteStudentById(String newId);
}
