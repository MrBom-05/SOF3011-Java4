package com.example.controllers.admin;

import com.example.models.HoaDonChiTietCustom;
import com.example.services.HoaDonChiTietService;
import com.example.services.HoaDonService;
import com.example.services.implement.HoaDonChiTietServiceImplement;
import com.example.services.implement.HoaDonServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet({"/admin/hoa-don/index", "/admin/hoa-don/detail", "/admin/hoa-don/edit", "/admin/hoa-don/update"})
public class HoaDonServlet extends HttpServlet {

    private HoaDonService hoaDonService = new HoaDonServiceImplement();

    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImplement();

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
//        HttpSession session = request.getSession();
//        Boolean check = (Boolean) session.getAttribute("check");
//        if (check == null){
//            check = true;
//        }
//        request.setAttribute("check", check);

        request.setAttribute("listHoaDon", hoaDonService.getListHoaDon());

        request.setAttribute("view", "/views/admin/hoa-don/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("view", "/views/admin/chi-tiet-sp/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID idHD = UUID.fromString(request.getParameter("id"));

        request.setAttribute("hoaDon", hoaDonService.getByID(idHD));

        List<HoaDonChiTietCustom> list = hoaDonChiTietService.getListByID(idHD);
        for (HoaDonChiTietCustom hoaDonChiTietCustom : list) {
            String fileName = hoaDonChiTietCustom.getAnh();
            if (fileName != null) {
                hoaDonChiTietCustom.setAnh(request.getContextPath() + "/images/" + fileName);
            }
        }

        request.setAttribute("list", list);

        request.setAttribute("view", "/views/admin/hoa-don/bill-detail.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chi-tiet-sp/index");
    }
}
