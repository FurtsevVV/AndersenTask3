package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.Legion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.List;

public class LegionDAO implements LegionDAOInterface {


    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Legion.class)
            .buildSessionFactory();


    public void insert(Legion legion) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(legion);
            session.getTransaction().commit();
            session.close();
    }

    @Override
    public void deleteById(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Legion legion = session.load(Legion.class, id);
session.delete(legion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Legion getLegionById(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
Legion legion = session.get(Legion.class, id);
        session.getTransaction().commit();
        session.close();

        return legion;
    }

    @Override
    public void updateLegion(Legion legion) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
         session.update(legion);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Legion> findAllLegion() throws ClassNotFoundException, NoSuchMethodException {
        List<Legion> legionList;
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            legionList = session.createQuery("from Legion", Legion.class).list();
            session.getTransaction().commit();
            session.close();
        return legionList;
    }

    @Override
    public int findLegionIdByName(String legionName) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Legion where legion_name=:name");
        query.setParameter("name", legionName);
        Legion legion = (Legion) query.uniqueResult();
        session.getTransaction().commit();
        session.close();

        if(legion == null)
            return -1;
        return legion.getId();
    }



}
