package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.Legion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

}
