package com.dao;

import com.model.Assignedcourse;
import com.model.Course;


import java.util.List;

public interface AssignedCourseDao {

    public List<Assignedcourse> getAll(String studentid);

    public void save(Assignedcourse assignedcourse);

    public void delete(int id);

    public Assignedcourse get(int id);

    public List<Assignedcourse> getStudentList(String coursename,String secction);

    public void UpdateMarks(int id,String marks);

    

}
