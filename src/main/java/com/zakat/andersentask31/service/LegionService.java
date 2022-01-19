package com.zakat.andersentask31.service;

import com.zakat.andersentask31.DAO.LegionDAO;
import com.zakat.andersentask31.DAO.LegionDAOInterface;
import com.zakat.andersentask31.entity.Legion;

import java.sql.SQLException;
import java.util.List;

public class LegionService implements LegionServiceInterface {

    LegionDAOInterface legionDAO = new LegionDAO();
//
//    public LegionService (LegionDAOInterface legionServiceInterface){
//        this.legionDAO = legionServiceInterface;
//    }


    @Override
    public void insert(Legion legion) throws SQLException {
        legionDAO.insert(legion);
    }

    @Override
    public void deleteById(int id) {
        legionDAO.deleteById(id);
    }

    @Override
    public Legion getLegionById(int id) {
        return legionDAO.getLegionById(id);

    }

    @Override
    public void updateLegion(Legion legion) {
        legionDAO.updateLegion(legion);
    }

    @Override
    public List<Legion> findAllLegion() throws ClassNotFoundException, NoSuchMethodException {
        return legionDAO.findAllLegion();
    }

    @Override
    public int findLegionIdByName(String legionName) {
        return legionDAO.findLegionIdByName(legionName);
    }
}
