package com.service;

import com.dao.CourseDao;
import com.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAll() {
        return courseDao.getAll();
    }


    @Override
    public void save(Course course) {
        courseDao.save(course);
    }


    @Override
    public Course get(int id) {
        return courseDao.get(id);
    }

    @Override
    public void update(Course course) {
        courseDao.update(course);
    }

    @Override
    public void delete(int id) {
        courseDao.delete(id);
    }

    @Override
    public List<Course> getAll(String firstName) {
        return courseDao.getAll(firstName);
    }
}
