package com.poly.pe.controllers;

import com.poly.pe.entities.KhachHang;
import com.poly.pe.repositories.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/detail",
        "/khach-hang/delete"
})
public class KhachHangServlet extends HttpServlet {


    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("delete")) {

            HttpSession session = request.getSession();

            KhachHang khachHang = khachHangRepository.getByMa(request.getParameter("ma"));
            if (khachHangRepository.delete(khachHang)) {
                session.setAttribute("thongBao", "Xoa thanh cong");
            }
            response.sendRedirect(request.getContextPath() + "/khach-hang/hien-thi");
        } else if (uri.contains("detail")) {
            request.setAttribute("khachHang", khachHangRepository.getByMa(request.getParameter("ma")));
            request.setAttribute("list", khachHangRepository.getList());
            request.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(request, response);
        } else {
            request.setAttribute("list", khachHangRepository.getList());
            request.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String quocGia = request.getParameter("quocGia");


        if (ma.trim().isEmpty() || ten.trim().isEmpty() || diaChi.trim().isEmpty() || quocGia.trim().isEmpty()) {
            session.setAttribute("thongBao", "Khong duoc de trong");
            response.sendRedirect(request.getContextPath() + "/khach-hang/hien-thi");
            return;
        }

        KhachHang khachHang = new KhachHang(ma, ten, diaChi, quocGia);

        if (khachHangRepository.insert(khachHang)) {
            session.setAttribute("thongBao", "Them thanh cong");
        }
        response.sendRedirect(request.getContextPath() + "/khach-hang/hien-thi");
    }
}
