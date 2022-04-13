package com.service;

import com.model.Course;
import com.model.Student;

public interface StudentService {

    public void save(Student student);

    public Student getStudent(Student student);
}
