package com.dao;

import com.model.Assignedcourse;
import com.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AssignedCourseDaoImp implements AssignedCourseDao{


    private final SessionFactory sessionFactory;

    public AssignedCourseDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Assignedcourse> getAll(String studentid) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Assignedcourse> courseQuery = session.createQuery("from Assignedcourse where Studetid=:studentid ", Assignedcourse.class);
        courseQuery.setParameter("studentid", studentid);
        List<Assignedcourse> assignedcourses = courseQuery.getResultList();
        return assignedcourses == null ? new ArrayList<Assignedcourse>() : assignedcourses;

    }

    @Override
    public void save(Assignedcourse assignedcourse) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(assignedcourse);
    }

    @Override
    public Assignedcourse get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Assignedcourse.class, id);
    }


    @Override
    public void delete(int id) {
        Assignedcourse assignedcourse = get(id);
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(assignedcourse);
    }
}
