package com.dao;

import com.model.Faculty;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class FacultyDaoImp implements FacultyDao{
    private final SessionFactory sessionFactory;


    public FacultyDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Faculty faculty) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(faculty);
    }

    @Override
    public Faculty getFaculty(Faculty faculty) {

        Session session = this.sessionFactory.getCurrentSession();

        try {
            Query<Faculty> query = session.createQuery("from Faculty where FacultyId =:ftID and FacultyPass =:ftpass",Faculty.class);
            query.setParameter("ftID", faculty.getFacultyId());
            query.setParameter("ftpass", faculty.getFacultyPass());
            faculty = query.getSingleResult();
            return faculty;
        }catch (NoResultException e) {
            // TODO: handle exception
            return null;
        }
    }
}
