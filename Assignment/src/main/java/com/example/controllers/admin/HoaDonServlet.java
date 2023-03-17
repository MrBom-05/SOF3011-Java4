package com.example.controllers.admin;

import com.example.models.HoaDonCustom;
import com.example.services.HoaDonService;
import com.example.services.implement.HoaDonServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/hoa-don/index", "/admin/hoa-don/detail", "/admin/hoa-don/edit", "/admin/hoa-don/update"})
public class HoaDonServlet extends HttpServlet {

    private HoaDonService hoaDonService = new HoaDonServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("edit")) {
            edit(request, response);
        } else if (url.contains("detail")) {
            detail(request, response);
        } else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        update(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HoaDonCustom> listHoaDon = hoaDonService.getListHoaDon();
        request.setAttribute("listHoaDon", listHoaDon);
        request.getRequestDispatcher("/views/admin/hoa-don/index.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/views/admin/chi-tiet-sp/update.jsp").forward(request, response);
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chi-tiet-sp/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chi-tiet-sp/index");
    }
}
