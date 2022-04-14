package com.dao;

import com.model.Faculty;
import com.model.Student;

public interface FacultyDao {
    public void save(Faculty faculty);

    public Faculty getFaculty(Faculty faculty);
}
