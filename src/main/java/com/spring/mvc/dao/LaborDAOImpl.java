package com.spring.mvc.dao;

import com.spring.mvc.entity.Labor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class LaborDAOImpl implements LaborDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Labor> getAllLabors() {
        Session session = sessionFactory.getCurrentSession();
        List<Labor> labors = session.createQuery("from Labor", Labor.class).getResultList();
        return labors;
    }

    @Override
    public void saveLabor(Labor labor) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(labor);
    }

    @Override
    public Labor getLaborById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Labor labor = session.get(Labor.class, id);
        return labor;
    }

    @Override
    public void deleteLabor(int id) {
        Session session = sessionFactory.getCurrentSession();
        Labor labor = session.get(Labor.class, id);
        session.delete(labor);
    }
}