package com.poly.pe.controllers;

import com.poly.pe.entities.NhanVien;
import com.poly.pe.repositories.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/delete"
})
public class NhanVienServlet extends HttpServlet {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String uri = request.getRequestURI();
        if (uri.contains("delete")){
            String ma = request.getParameter("ma");
            NhanVien nhanVien = nhanVienRepository.getByMa(ma);
            if (nhanVienRepository.delete(nhanVien)){
                session.setAttribute("thongBao", "Xoa thanh cong");
            }
            response.sendRedirect(request.getContextPath() + "/nhan-vien/hien-thi");
        } else if (uri.contains("detail")) {
            String ma = request.getParameter("ma");
            NhanVien nhanVien = nhanVienRepository.getByMa(ma);

            request.setAttribute("nv", nhanVien);
            request.setAttribute("list", nhanVienRepository.getList());
            request.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(request, response);
        } else {
            request.setAttribute("list", nhanVienRepository.getList());
            request.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(ma);
        nhanVien.setTen(ten);
        nhanVien.setDiaChi(diaChi);
        nhanVien.setGioiTinh(gioiTinh);

        boolean check = nhanVienRepository.insert(nhanVien);

        if (check){
            session.setAttribute("thongBao", "Them Moi Thanh Cong");
        }
        response.sendRedirect(request.getContextPath() + "/nhan-vien/hien-thi");

    }


}
