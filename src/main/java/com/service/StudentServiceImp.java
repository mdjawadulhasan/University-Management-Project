package com.service;

import com.dao.StudentDao;
import com.model.Student;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Service
@Transactional
public class StudentServiceImp implements StudentService {


    private final StudentDao studentDao;



    public StudentServiceImp(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student getStudent(Student student) {
        return studentDao.getStudent(student);
    }
}
