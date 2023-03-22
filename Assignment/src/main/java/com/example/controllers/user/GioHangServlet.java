package com.example.controllers.user;

import com.example.entities.KhachHang;
import com.example.models.GioHangChiTietCustom;
import com.example.models.SanPhamCustom;
import com.example.services.GioHangChiTietService;
import com.example.services.implement.GioHangChiTietServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/cart"
})
public class GioHangServlet extends HttpServlet {

    private GioHangChiTietService gioHangChiTietService = new GioHangChiTietServiceImplement();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
            request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
            return;
        }

        List<GioHangChiTietCustom> list = gioHangChiTietService.getList(khachHang.getId());
        for (GioHangChiTietCustom gioHangChiTietCustom : list) {
            String fileName = gioHangChiTietCustom.getAnh();
            if (fileName != null) {
                gioHangChiTietCustom.setAnh(request.getContextPath() + "/images/" + fileName);
            }
        }

        request.setAttribute("list", list);

        request.setAttribute("view", "/views/user/gio-hang.jsp");
        request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
