package com.service;

import com.dao.FacultyDao;
import com.model.Faculty;
import com.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FacultyServiceImp implements FacultyService{


    private final FacultyDao facultyDao;

    public FacultyServiceImp(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }


    @Override
    public void save(Faculty faculty) {
        facultyDao.save(faculty);
    }

    @Override
    public Faculty getFaculty(Faculty faculty) {
        return facultyDao.getFaculty(faculty);
    }
}
