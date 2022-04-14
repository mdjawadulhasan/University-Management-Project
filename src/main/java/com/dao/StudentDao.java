package com.dao;

import com.model.Course;
import com.model.Student;

public interface StudentDao {

    public void save(Student student);

    public Student getStudent(Student student);

    public void update(Student student);


}
