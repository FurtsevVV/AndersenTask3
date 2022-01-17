package com.zakat.andersentask31.servlets.agregation;


import com.zakat.andersentask31.DAO.TotalModelDAO;
import com.zakat.andersentask31.DAO.TotalModelDAOInterface;
import com.zakat.andersentask31.entity.Legion;
import com.zakat.andersentask31.model.TotalInfoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Objects;

@WebServlet("/addtotalinfo")
public class AddTotalInfoServlet extends HttpServlet {
TotalModelDAOInterface totalDAO = new TotalModelDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/add-total-info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TotalInfoModel totalInfoModel = null;
                if(Objects.equals(req.getParameter("planet"), "") || Objects.equals(req.getParameter("legion"), "")){
        getServletContext().getRequestDispatcher("/add-total-info.jsp").forward(req, resp);}
        if(isInteger(req.getParameter("population")) && isInteger(req.getParameter("contingent"))){
            String planetname = req.getParameter("planet");
            int population = Integer.parseInt(req.getParameter("population"));
            String legionname = req.getParameter("legion");
            int contingent =Integer.parseInt(req.getParameter("contingent"));
             totalInfoModel = new TotalInfoModel(planetname, population, legionname, contingent);

        } else {
            getServletContext().getRequestDispatcher("/add-total-info.jsp").forward(req, resp);

        }
        try {
            totalDAO.addTotalModelToDatabase(totalInfoModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/totalinfo");    }



    public boolean isInteger(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}


