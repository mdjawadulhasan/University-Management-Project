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
    public List<Course> getAll(String coursename) {
        Session session = sessionFactory.getCurrentSession();
        Query<Course> courseQuery = session.createQuery("from Course where CourseName like '%" + coursename + "%'", Course.class);
        return courseQuery.getResultList();
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
    public List<Course> SelectedCourse(String FacultyName) {


        Session session = sessionFactory.getCurrentSession();
        Query<Course> courseQuery = session.createQuery("from Course where FacultyName=:FacultyName", Course.class);
        courseQuery.setParameter("FacultyName", FacultyName);
        List<Course> courses = courseQuery.getResultList();
        return courses == null ? new ArrayList<Course>() : courses;
    }

    @Override
    public void Addfaculty(int id, String facultyname) {
        Session session = sessionFactory.getCurrentSession();
        String qryString = "update Course c set c.FacultyName=:facultyname where c.id=:id";
        Query query = session.createQuery(qryString);
        query.setParameter("facultyname", facultyname);
        query.setParameter("id", id);
        query.executeUpdate();
        int count = query.executeUpdate();

    }

    @Override
    public void Removefaculty(int id, String facultyname) {
        Session session = sessionFactory.getCurrentSession();
        String qryString = "update Course c set c.FacultyName='' where c.id=:id";
        Query query = session.createQuery(qryString);
        query.setParameter("id", id);
        query.executeUpdate();
        int count = query.executeUpdate();
    }

    @Override
    public List<Course> getavailable(String FacultyName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Course> courseQuery = session.createQuery("from Course ", Course.class);
        List<Course> courses = courseQuery.getResultList();
        return courses == null ? new ArrayList<Course>() : courses;
    }


}