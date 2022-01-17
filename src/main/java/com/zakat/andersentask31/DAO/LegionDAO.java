package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.Legion;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LegionDAO implements LegionDAOInterface {

    private static String url = "jdbc:postgresql://localhost:5432/andersendb";
    private static String username = "postgres";
    private static String password = "root";
    private static String postgresDriver = "org.postgresql.Driver";


    public void insert(Legion legion) {
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO legions (legion_name) Values (?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, legion.getLegion_name());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "DELETE FROM legions WHERE id = (?)";
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
    public Legion getLegionById(int id) {
        Legion legion = new Legion();
        int gettingID = 0;
        String legionName = "";
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM legions WHERE id = (?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        gettingID = resultSet.getInt("id");
                        legionName = resultSet.getString("legion_name");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        legion.setId(gettingID);
        legion.setLegion_name(legionName);
        return legion;
    }

    @Override
    public void updateLegion(Legion legion) {
        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "UPDATE legions SET legion_name = (?) WHERE id = (?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, legion.getLegion_name());
                    preparedStatement.setInt(2, legion.getId());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Legion> findAllLegion() throws ClassNotFoundException, NoSuchMethodException {
        List<Legion> legionList = new ArrayList<>();

        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM legions");

                while (resultSet.next()) {
                    int id = Integer.parseInt(resultSet.getString("id"));
                    String legionname = resultSet.getString("legion_name");
                    Legion legion = new Legion();
                    legion.setLegion_name(legionname);
                    legion.setId(id);
                    legionList.add(legion);
                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return legionList;
    }

    @Override
    public int findLegionIdByName(String legionName) {

                try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT legion_name, id FROM legions";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        String legionInBase = resultSet.getString("legion_name");
                        int legionInBaseID = resultSet.getInt("id");
                        if(legionName.equals(legionInBase))
                            return legionInBaseID;
                                            }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return -1;
    }

}
