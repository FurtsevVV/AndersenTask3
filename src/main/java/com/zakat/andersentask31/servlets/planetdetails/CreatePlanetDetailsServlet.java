package com.zakat.andersentask31.servlets.planetdetails;

import com.zakat.andersentask31.entity.PlanetDetails;
import com.zakat.andersentask31.service.PlanetDetailsService;
import com.zakat.andersentask31.service.PlanetDetailsServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-planet")
public class CreatePlanetDetailsServlet extends HttpServlet {

    PlanetDetailsServiceInterface planetDAO = new PlanetDetailsService();

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

    }
}
