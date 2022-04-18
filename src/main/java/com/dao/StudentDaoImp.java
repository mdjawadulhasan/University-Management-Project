package com.dao;

import com.model.Course;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao{
    private final SessionFactory sessionFactory;

    public StudentDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public Student getStudent(Student student) {

        Session session = this.sessionFactory.getCurrentSession();
        int StudentIsActive=1;
        try {
        Query<Student> query = session.createQuery("from Student where StudentID =:StudentID and Studentpass =:Studentpass and StudentIsActive=:StudentIsActive",Student.class);
        query.setParameter("StudentID", student.getStudentID());
        query.setParameter("Studentpass", student.getStudentpass());
        query.setParameter("StudentIsActive",StudentIsActive);

        student = query.getSingleResult();
            return student;
        }catch (NoResultException e) {
            // TODO: handle exception
            return null;
        }
    }

    @Override
    public void update(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    public List<Student> getvalibstudent(int status) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("from Student where StudentIsActive=:StudentIsActive",Student.class);
        query.setParameter("StudentIsActive",status);
        List<Student> students = query.getResultList();
        return students == null ? new ArrayList<Student>() : students;
    }


    @Override
    public void changestatus(int id, int status) {
        Session session = sessionFactory.getCurrentSession();
        String qryString = "update Student s set s.StudentIsActive=:StudentIsActive where s.id=:id";
        Query query = session.createQuery(qryString);
        query.setParameter("StudentIsActive", status);
        query.setParameter("id", id);
        query.executeUpdate();
        int count = query.executeUpdate();
    }


}