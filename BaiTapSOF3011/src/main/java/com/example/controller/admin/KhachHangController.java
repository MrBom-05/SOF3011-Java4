package com.example.controller.admin;

import com.example.model.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/khachhang/index", "/khachhang/create", "/khachhang/edit", "/khachhang/delete", "/khachhang/update", "/khachhang/store"})
public class KhachHangController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("create")) {
            create(request, response);
        } else if (url.contains("edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        store(request, response);
    }

    List<KhachHang> list = new ArrayList<>();


    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("khachHang", list);
        request.getRequestDispatcher("/views/khachhang/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khachhang/create.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khachhang/update.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matKhau");

        KhachHang khachHang = new KhachHang(ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, email, matKhau);
        list.add(khachHang);
        System.out.println(list);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
