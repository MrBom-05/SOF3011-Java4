package com.example.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({
        "khachhang/index",
        "khachhang/create",
        "khachhang/edit"
})
public class KhachHangController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("create")) {
            create(request, response);
        } else if (url.contains("edit")) {
            update(request, response);
        } else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khachhang/create.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khachhang/update.jsp").forward(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<SinhVien> ds = this.svRepo.getAll();
//        request.setAttribute("ds", ds);
        String view = "/views/khachhang/index.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }
}
