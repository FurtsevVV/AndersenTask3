package com.zakat.andersentask31.servlets.planetdetails;

import com.zakat.andersentask31.DAO.PlanetDAOInterface;
import com.zakat.andersentask31.DAO.PlanetDetailsDAO;
import com.zakat.andersentask31.entity.Legion;
import com.zakat.andersentask31.entity.PlanetDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create-planet")
public class CreatePlanetDetailsServlet extends HttpServlet {

    PlanetDAOInterface planetDAO = new PlanetDetailsDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create-planet.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String planet = req.getParameter("planet");
        int population = Integer.parseInt(req.getParameter("population"));
        PlanetDetails planetDetails = new PlanetDetails(planet, population);
        planetDAO.addPlanetDetails(planetDetails);

        resp.sendRedirect(req.getContextPath() + "/all-planet");

}}
