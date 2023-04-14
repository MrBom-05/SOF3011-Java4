package com.example.be.controller;

import com.example.be.entities.CuaHang;
import com.example.be.repositories.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({
        "/cua-hang",
        "/cua-hang/hien-thi",
        "/cua-hang/view-add",
        "/cua-hang/add",
        "/cua-hang/detail",
        "/cua-hang/delete",
        "/cua-hang/view-update",
        "/cua-hang/update"
})
public class CuaHangServlet extends HttpServlet {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("delete")) {
            cuaHangRepository.delete(cuaHangRepository.getByMa(request.getParameter("ma")));
            response.sendRedirect(request.getContextPath() + "/cua-hang/hien-thi");
        } else if (uri.contains("detail")) {
            request.setAttribute("cuaHang", cuaHangRepository.getByMa(request.getParameter("ma")));
            request.getRequestDispatcher("/fe/view/update.jsp").forward(request, response);
        } else if (uri.contains("view-add")) {
            request.getRequestDispatcher("/fe/view/create.jsp").forward(request, response);
        } else if (uri.contains("view-update")) {
            request.setAttribute("cuaHang", cuaHangRepository.getByMa(request.getParameter("ma")));
            request.getRequestDispatcher("/fe/view/update.jsp").forward(request, response);
        } else if (uri.contains("hien-thi")) {
            request.setAttribute("list", cuaHangRepository.getList());
            request.getRequestDispatcher("/fe/view/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/fe/view/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String thanhPho = request.getParameter("thanhPho");
        String diaChi = request.getParameter("diaChi");

        if (uri.contains("update")) {


            CuaHang cuaHang = cuaHangRepository.getByMa(ma);
            cuaHang.setTen(ten);
            cuaHang.setThanhPho(thanhPho);
            cuaHang.setDiaChi(diaChi);

            cuaHangRepository.update(cuaHang);
        } else {


            CuaHang cuaHang = new CuaHang();
            cuaHang.setMa(ma);
            cuaHang.setTen(ten);
            cuaHang.setThanhPho(thanhPho);
            cuaHang.setDiaChi(diaChi);

            cuaHangRepository.insert(cuaHang);
        }
        response.sendRedirect(request.getContextPath() + "/cua-hang/hien-thi");
    }
}
