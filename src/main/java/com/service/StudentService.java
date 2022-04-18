package com.service;

import com.model.Course;
import com.model.Student;

import java.util.List;

public interface StudentService {

    public void save(Student student);

    public Student getStudent(Student student);

    public List<Student> getvalibstudent(int status);

    public void update(Student student);

    public void changestatus(int id,int status);



}
