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
import java.util.List;

@WebServlet("/all-planet")
public class AllPlanetServlet extends HttpServlet {

PlanetDAOInterface planetDAO = new PlanetDetailsDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PlanetDetails> planetDetails = null;
        planetDetails = planetDAO.findAllPlanetDetails();
        req.setAttribute("planetList", planetDetails);
        getServletContext().getRequestDispatcher("/planets-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
