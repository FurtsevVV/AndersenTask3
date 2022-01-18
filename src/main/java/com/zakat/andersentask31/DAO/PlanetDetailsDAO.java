package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.Legion;
import com.zakat.andersentask31.entity.PlanetDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetDetailsDAO implements PlanetDAOInterface{

       SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Legion.class)
            .buildSessionFactory();

    @Override
    public List<PlanetDetails> findAllPlanetDetails() {
List<PlanetDetails> planetDetailsList = new ArrayList<>();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        planetDetailsList = session.createQuery("from PlanetDetails", PlanetDetails.class).list();
        session.getTransaction().commit();
        session.close();
        return planetDetailsList;
    }

    @Override
    public void addPlanetDetails(PlanetDetails planetDetails) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(planetDetails);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public PlanetDetails findPlanetDetailsById(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        PlanetDetails planetDetails = session.get(PlanetDetails.class, id);
        session.getTransaction().commit();
        session.close();
        return planetDetails;

    }

    @Override
    public void deletePlanetDetails(int id) {

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        PlanetDetails planetDetails = session.load(PlanetDetails.class, id);
        session.delete(planetDetails);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void updatePlanetDetails(PlanetDetails planetDetails) {

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.update(planetDetails);
        session.getTransaction().commit();
        session.close();


    }

    @Override
    public int findPlanetDetailsByPlanetName(String planetName) {

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from PlanetDetails where planet=:name");
        query.setParameter("name", planetName);
        PlanetDetails planetDetails = (PlanetDetails) query.uniqueResult();
        session.getTransaction().commit();
        session.close();

        if(planetDetails == null)
            return -1;
        return planetDetails.getPlanet_id();

    }
}
