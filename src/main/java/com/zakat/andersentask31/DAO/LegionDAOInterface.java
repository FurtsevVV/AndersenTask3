package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.Legion;

import java.sql.SQLException;
import java.util.List;

public interface LegionDAOInterface {
    public void insert(Legion legion) throws SQLException;

    public void deleteById(int id);

    public Legion getLegionById(int id);

    public void updateLegion(Legion legion);

    public List<Legion> findAllLegion() throws ClassNotFoundException, NoSuchMethodException;

    int findLegionIdByName(String legionName);
}
