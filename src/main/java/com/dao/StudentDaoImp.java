package com.dao;

import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

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
}
