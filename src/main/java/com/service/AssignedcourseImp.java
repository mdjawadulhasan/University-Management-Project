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

    @Override
    public void delete(int id) {
        assignedCourseDao.delete(id);
    }

    @Override
    public List<Assignedcourse> getStudentList(String coursename, String secction) {
        return assignedCourseDao.getStudentList(coursename,secction);
    }


    public Assignedcourse get(int id){
        return assignedCourseDao.get(id);
    }

    public void UpdateMarks(int id,String marks) {
        assignedCourseDao.UpdateMarks(id,marks);
    }
}
