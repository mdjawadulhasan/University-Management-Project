package com.service;

import com.dao.AssignedCourseDao;
import com.model.Assignedcourse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssignedcourseImp implements AssignedcourseService{

    private final AssignedCourseDao assignedCourseDao;

    public AssignedcourseImp(AssignedCourseDao assignedCourseDao) {
        this.assignedCourseDao = assignedCourseDao;
    }

    @Override
    public List<Assignedcourse> getAll(String studentid) {
        return assignedCourseDao.getAll(studentid);
    }

    @Override
    public void save(Assignedcourse assignedcourse) {
        assignedCourseDao.save(assignedcourse);
    }
}
