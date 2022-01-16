package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.Legion;
import com.zakat.andersentask31.entity.PlanetDetails;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetDetailsDAO implements PlanetDAOInterface{

    private static String url = "jdbc:postgresql://localhost:5432/andersendb";
    private static String username = "postgres";
    private static String password = "root";
    private static String postgresDriver = "org.postgresql.Driver";

    @Override
    public List<PlanetDetails> findAllPlanetDetails() {
List<PlanetDetails> planetDetailsList = new ArrayList<>();
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM planet_details");
                while (resultSet.next()) {
                    int id = Integer.parseInt(resultSet.getString("planet_id"));
                    String planet = resultSet.getString("planet_name");
                    int population = resultSet.getInt("population");
                    PlanetDetails planetDet = new PlanetDetails();
                    planetDet.setPlanet_id(id);
                    planetDet.setPlanet(planet);
                    planetDet.setPopulation(population);
                    planetDetailsList.add(planetDet);
                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return planetDetailsList;
    }

    @Override
    public void addPlanetDetails() {

    }

    @Override
    public PlanetDetails findPlanetDetailsById(int id) {
        return null;
    }

    @Override
    public void deletePlanetDetails(int id) {

    }

    @Override
    public void updatePlanetDetails(PlanetDetails planetDetails) {

    }
}
