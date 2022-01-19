package com.zakat.andersentask31.servlets.agregation;

import com.zakat.andersentask31.DAO.PlanetLegionDAO;
import com.zakat.andersentask31.DAO.PlanetLegionDAOInterface;
import com.zakat.andersentask31.model.TotalInfoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/totalinfo")
public class TotalInformationServlet extends HttpServlet {

    PlanetLegionDAOInterface plDAO = new PlanetLegionDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TotalInfoModel> totalList = null;
        totalList = plDAO.getAllInformation();
        System.out.println(totalList);
        req.setAttribute("totallist", totalList);
        getServletContext().getRequestDispatcher("/total-info.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
