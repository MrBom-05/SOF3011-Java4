package com.example.controller;

import com.example.model.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/khachhang/index",
        "/khachhang/create",
        "/khachhang/edit"})
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

    List<KhachHang> khachHang = new ArrayList<>();



    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        khachHang.add(new KhachHang("1", "PH27937", "Kỳ", "2003/11/27", "0962894271", "Khu 8, Đại Phạm", "Việt Trì", "Việt Nam", "kynnph27937@fpt.edu.vn", "123"));

//        request.setAttribute("khachHang", khachHang);
        request.getRequestDispatcher("/views/khachhang/index.jsp").forward(request, response);
    }

}
