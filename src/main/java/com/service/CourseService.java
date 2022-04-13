package com.service;

import com.model.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getAll();

    public void save(Course course);

    public Course get(int id);

    public void update(Course course);

    public void delete(int id);

    public List<Course> getAll(String firstName);
}
