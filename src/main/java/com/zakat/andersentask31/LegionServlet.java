package com.zakat.andersentask31;

import com.zakat.andersentask31.entity.Legion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/legionslist")
public class LegionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Legion> legionList = new ArrayList<>();


        PrintWriter pw = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/andersendb", "postgres", "root");
            Statement statement = connection.createStatement();
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
        req.setAttribute("legionList", legionList);
        getServletContext().getRequestDispatcher("/legionslist.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
