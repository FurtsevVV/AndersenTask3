package com.zakat.andersentask31.servlets;

import com.zakat.andersentask31.DAO.LegionDAO;
import com.zakat.andersentask31.DAO.LegionDAOInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteLegion")
public class DeleteLegionServlet extends HttpServlet {

    LegionDAOInterface legionDAO = new LegionDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        legionDAO.deleteById(id);
        resp.sendRedirect(req.getContextPath() + "/legionslist");

    }


}
