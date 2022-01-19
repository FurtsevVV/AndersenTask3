package com.zakat.andersentask31.servlets;

import com.zakat.andersentask31.entity.Legion;
import com.zakat.andersentask31.service.LegionService;
import com.zakat.andersentask31.service.LegionServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateLegion")
public class UpdateLegionServlet extends HttpServlet {
    LegionServiceInterface legionDAO = new LegionService();
    int id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        Legion legion = legionDAO.getLegionById(id);
        req.setAttribute("id", legion.getId());
        req.setAttribute("legion_name", legion.getLegion_name());
        getServletContext().getRequestDispatcher("/update-legion.jsp").forward(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Legion legion = new Legion();
        legion.setLegion_name(req.getParameter("legion_name"));
        legion.setId(id);
        legionDAO.updateLegion(legion);
        resp.sendRedirect(req.getContextPath() + "/legionslist");

    }

}
