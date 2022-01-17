package com.zakat.andersentask31.DAO;

import com.zakat.andersentask31.entity.PlanetDetails;
import com.zakat.andersentask31.model.TotalInfoModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetLegionDAO implements PlanetLegionDAOInterface{

    private static String url = "jdbc:postgresql://localhost:5432/andersendb";
    private static String username = "postgres";
    private static String password = "root";
    private static String postgresDriver = "org.postgresql.Driver";

    @Override
    public List<TotalInfoModel> getAllInformation() {
List<TotalInfoModel> totalModelList = new ArrayList<>();

        try {
            Class.forName(postgresDriver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select planet_name,population,legion_name,avg(legion_contingent) from legions l\n" +
                        "join planet_legions pl on l.id=pl.legion_id\n" +
                        "join  planet_details pd on pd.planet_id=pl.planet_id\n" +
                        "group by l.id,pd.planet_id;");
                while (resultSet.next()) {
                    String planetName = resultSet.getString("planet_name");
                    int population = resultSet.getInt("population");
                    String legionName = resultSet.getString("legion_name");
                    int contingent = resultSet.getInt("avg");
                    TotalInfoModel model = new TotalInfoModel();
                    model.setPlanetname(planetName);
                    model.setPopulation(population);
                    model.setLegion(legionName);
                    model.setLeg_contingent(contingent);
                    totalModelList.add(model);
                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return totalModelList;
    }
}
