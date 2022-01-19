package com.zakat.andersentask31;

import com.zakat.andersentask31.entity.Legion;
import com.zakat.andersentask31.service.LegionService;
import com.zakat.andersentask31.service.LegionServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/create-legion")

public class CreateLegionServlet extends HttpServlet {
    LegionServiceInterface legionDAO = new LegionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create-legion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("legion_name");
        Legion legion = new Legion(name);
        try {
            legionDAO.insert(legion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/legionslist");
    }

}

