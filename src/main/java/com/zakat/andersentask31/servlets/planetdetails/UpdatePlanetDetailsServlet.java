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

@WebServlet("/updatePlanet")
public class UpdatePlanetDetailsServlet extends HttpServlet {

    PlanetDetailsServiceInterface planetDAO = new PlanetDetailsService();
    int id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        PlanetDetails planetDetails = planetDAO.findPlanetDetailsById(id);
        req.setAttribute("id", planetDetails.getPlanet_id());
        req.setAttribute("planet", planetDetails.getPlanet());
        req.setAttribute("population", planetDetails.getPopulation());
        getServletContext().getRequestDispatcher("/update_planet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlanetDetails pd = new PlanetDetails();
        pd.setPlanet(req.getParameter("planet"));
        pd.setPlanet_id(id);
        pd.setPopulation(Integer.parseInt(req.getParameter("population")));

        planetDAO.updatePlanetDetails(pd);
        resp.sendRedirect(req.getContextPath() + "/all-planet");
    }
}
