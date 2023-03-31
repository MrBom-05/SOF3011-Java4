package com.example.controllers.user;

import com.example.entities.ChiTietSP;
import com.example.entities.HoaDon;
import com.example.entities.HoaDonChiTiet;
import com.example.entities.KhachHang;
import com.example.services.ChiTietSPService;
import com.example.services.HoaDonChiTietService;
import com.example.services.HoaDonService;
import com.example.services.implement.ChiTietSPServiceImplement;
import com.example.services.implement.HoaDonChiTietServiceImplement;
import com.example.services.implement.HoaDonServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@WebServlet({"/bill", "/add/bill", "/update/bill"})
public class HoaDonServlet extends HttpServlet {

    private HoaDonService hoaDonService = new HoaDonServiceImplement();

    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImplement();

    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add/bill")) {
            insert(request, response);
        } else if (uri.contains("update/bill")) {

        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
            request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
            return;
        }

        try {
            Random random = new Random();
            int pass = random.nextInt(10000) + 1;

            HoaDon hoaDon = new HoaDon();
            hoaDon.setMa(String.valueOf(pass));
            hoaDon.setKhachHang(khachHang);

            UUID idHD = hoaDonService.insert(hoaDon);
            UUID idSP = UUID.fromString(request.getParameter("id"));
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            BigDecimal giaBan = chiTietSPService.getGiaBanById(idSP);

            HoaDon hoaDonCT = new HoaDon();
            hoaDonCT.setId(idHD);
            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setId(idSP);

            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDonCT, chiTietSP, soLuong, giaBan);
            hoaDonChiTietService.insert(hoaDonChiTiet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/cart");
    }
}
