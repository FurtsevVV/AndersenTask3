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
import java.util.List;

@WebServlet("/legionslist")
public class LegionServlet extends HttpServlet {
    LegionServiceInterface legionDAO = new LegionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Legion> legionList = null;
        try {
            legionList = legionDAO.findAllLegion();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        req.setAttribute("legionList", legionList);

        getServletContext().getRequestDispatcher("/legionslist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
