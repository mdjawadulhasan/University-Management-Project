package com.dao;

import com.model.Course;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CourseDaoImp implements CourseDao {

    private final SessionFactory sessionFactory;

    public CourseDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Course> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Course> courseQuery = session.createQuery("from Course", Course.class);
        List<Course> courses = courseQuery.getResultList();
        return courses == null ? new ArrayList<Course>() : courses;
    }

    @Override
    public void save(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public Course get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public void update(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(course);
    }

    @Override
    public void delete(int id) {
        Course course = get(id);
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(course);
    }

    @Override
    public List<Course> getAll(String coursename) {
        Session session = sessionFactory.getCurrentSession();
        Query<Course> userQuery = session.createQuery("from Course where CourseName like '%" + coursename + "%'", Course.class);
        return userQuery.getResultList();
    }
}
