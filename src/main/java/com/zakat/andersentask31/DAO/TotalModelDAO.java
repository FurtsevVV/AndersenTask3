package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.Legion;
import com.zakat.andersentask31.entity.PlanetDetails;
import com.zakat.andersentask31.model.TotalInfoModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TotalModelDAO implements TotalModelDAOInterface{

    private static String url = "jdbc:postgresql://localhost:5432/andersendb";
    private static String username = "postgres";
    private static String password = "root";
    private static String postgresDriver = "org.postgresql.Driver";
    LegionDAOInterface legionDAO = new LegionDAO();
    PlanetDAOInterface planetDAO = new PlanetDetailsDAO();

    @Override
    public void addTotalModelToDatabase(TotalInfoModel totalInfoModel) throws SQLException {
        int addLegionId = 0;
        int addPlanetId = 0;
if(legionDAO.findLegionIdByName(totalInfoModel.getLegion()) == -1){
    legionDAO.insert(new Legion(totalInfoModel.getLegion()));
}
if(planetDAO.findPlanetDetailsByPlanetName(totalInfoModel.getPlanetname()) == -1){
    planetDAO.addPlanetDetails(new PlanetDetails(totalInfoModel.getPlanetname(), totalInfoModel.getPopulation()));
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                addLegionId = legionDAO.findLegionIdByName(totalInfoModel.getLegion());
                addPlanetId = planetDAO.findPlanetDetailsByPlanetName(totalInfoModel.getPlanetname());
                System.out.println("leg id" + addLegionId + " pl id = " + addPlanetId);
                String sql = "INSERT INTO planet_legions (planet_id, legion_id, legion_contingent) VALUES (?,?,?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, addPlanetId);
                    preparedStatement.setInt(2, addLegionId);
                    preparedStatement.setInt(3, totalInfoModel.getLeg_contingent());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }}}

