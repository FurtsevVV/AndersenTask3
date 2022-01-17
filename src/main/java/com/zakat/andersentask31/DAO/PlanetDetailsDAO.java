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
    public void addPlanetDetails(PlanetDetails planetDetails) {
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO planet_details (planet_name, population) Values (?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, planetDetails.getPlanet());
                    preparedStatement.setInt(2, planetDetails.getPopulation());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @Override
    public PlanetDetails findPlanetDetailsById(int id) {
PlanetDetails pd = new PlanetDetails();
int gettingID = 0;
String planet = "";
int population =0;
                try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM planet_details WHERE planet_id = (?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        gettingID = resultSet.getInt("planet_id");
                        planet = resultSet.getString("planet_name");
                        population = resultSet.getInt("population");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
pd.setPlanet_id(gettingID);
                pd.setPlanet(planet);
                pd.setPopulation(population);
return pd;


    }

    @Override
    public void deletePlanetDetails(int id) {
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "DELETE FROM planet_details WHERE planet_id = (?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void updatePlanetDetails(PlanetDetails planetDetails) {
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "UPDATE planet_details SET planet_name = (?), population = (?) WHERE planet_id = (?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, planetDetails.getPlanet());
                    preparedStatement.setInt(2, planetDetails.getPopulation());
                    preparedStatement.setInt(3, planetDetails.getPlanet_id());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @Override
    public int findPlanetDetailsByPlanetName(String planetName) {
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT planet_name, planet_id FROM planet_details";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        String planetInBase = resultSet.getString("planet_name");
                        int planetInBaseID = resultSet.getInt("planet_id");
                        if(planetInBase.equals(planetName))
                            return planetInBaseID;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return -1;
    }
}
