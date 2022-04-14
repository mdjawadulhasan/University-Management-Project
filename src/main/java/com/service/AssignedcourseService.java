package com.service;

import com.model.Assignedcourse;
import com.model.Course;

import java.util.List;

public interface AssignedcourseService {


    public List<Assignedcourse> getAll(String studentid);

    public void save(Assignedcourse assignedcourse);

    public void delete(int id);

}
