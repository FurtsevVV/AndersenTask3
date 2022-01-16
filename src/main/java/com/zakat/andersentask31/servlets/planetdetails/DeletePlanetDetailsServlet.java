package com.zakat.andersentask31.servlets.planetdetails;

import com.zakat.andersentask31.DAO.PlanetDAOInterface;
import com.zakat.andersentask31.DAO.PlanetDetailsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePlanet")
public class DeletePlanetDetailsServlet extends HttpServlet {

    PlanetDAOInterface planetDAO = new PlanetDetailsDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        planetDAO.deletePlanetDetails(id);
        resp.sendRedirect(req.getContextPath() + "/all-planet");    }
}
