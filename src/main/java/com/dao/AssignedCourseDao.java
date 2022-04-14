package com.dao;

import com.model.Assignedcourse;
import com.model.Course;


import java.util.List;

public interface AssignedCourseDao {

    public List<Assignedcourse> getAll(String studentid);

    public void save(Assignedcourse assignedcourse);
}
