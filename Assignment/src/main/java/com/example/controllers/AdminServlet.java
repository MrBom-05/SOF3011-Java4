package com.example.controllers;

import com.example.entities.GioHang;
import com.example.entities.KhachHang;
import com.example.entities.NhanVien;
import com.example.services.NhanVienService;
import com.example.services.implement.NhanVienServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({"/admin", "/admin/login"})
public class AdminServlet extends HttpServlet {

    private NhanVienService nhanVienService = new NhanVienServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("admin/login")) {
            request.getRequestDispatcher("/views/admin/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String matKhau = request.getParameter("password");

        HttpSession session = request.getSession();

        NhanVien nhanVien = nhanVienService.login(email, matKhau);
        if (nhanVien != null) {
            session.setAttribute("nhanVien", nhanVien);
            session.setAttribute("errorMessage", true);
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            session.setAttribute("errorMessage", false);
            response.sendRedirect(request.getContextPath() + "/admin/login");
        }
    }
}
