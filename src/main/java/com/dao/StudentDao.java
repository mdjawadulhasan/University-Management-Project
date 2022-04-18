package com.dao;

import com.model.Course;
import com.model.Student;

import java.util.List;

public interface StudentDao {

    public void save(Student student);

    public Student getStudent(Student student);

    public void update(Student student);

    public List<Student> getvalibstudent(int status);

    public void changestatus(int id,int status);

}
