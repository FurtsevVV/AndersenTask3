package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.Legion;
import com.zakat.andersentask31.entity.PlanetDetails;
import com.zakat.andersentask31.entity.PlanetLegion;
import com.zakat.andersentask31.entity.PlanetLegionPK;
import com.zakat.andersentask31.model.TotalInfoModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TotalModelDAO implements TotalModelDAOInterface {


    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(PlanetLegion.class)
            .buildSessionFactory();

    LegionDAOInterface legionDAO = new LegionDAO();
    PlanetDAOInterface planetDAO = new PlanetDetailsDAO();

    @Override
    public void addTotalModelToDatabase(TotalInfoModel totalInfoModel) throws SQLException {
        PlanetLegion planetLegion = new PlanetLegion();
        PlanetLegionPK plPK = new PlanetLegionPK();
        int addLegionId = 0;
        int addPlanetId = 0;
        if (legionDAO.findLegionIdByName(totalInfoModel.getLegion()) == -1) {
            legionDAO.insert(new Legion(totalInfoModel.getLegion()));
        }
        if (planetDAO.findPlanetDetailsByPlanetName(totalInfoModel.getPlanetname()) == -1) {
            planetDAO.addPlanetDetails(new PlanetDetails(totalInfoModel.getPlanetname(), totalInfoModel.getPopulation()));
            addLegionId = legionDAO.findLegionIdByName(totalInfoModel.getLegion());
            addPlanetId = planetDAO.findPlanetDetailsByPlanetName(totalInfoModel.getPlanetname());

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            plPK.setPlanet_id(addPlanetId);
            plPK.setLegion_id(addLegionId);
            planetLegion.setPlanetLegionPK(plPK);
            planetLegion.setContingent(totalInfoModel.getLeg_contingent());
            session.save(planetLegion);
            session.getTransaction().commit();
            session.close();

        }
    }
}

