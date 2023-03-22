package com.example.controllers.user;

import com.example.entities.ChiTietSP;
import com.example.entities.GioHang;
import com.example.entities.GioHangChiTiet;
import com.example.entities.KhachHang;
import com.example.models.GioHangChiTietCustom;
import com.example.models.SanPhamCustom;
import com.example.services.ChiTietSPService;
import com.example.services.GioHangChiTietService;
import com.example.services.GioHangService;
import com.example.services.implement.ChiTietSPServiceImplement;
import com.example.services.implement.GioHangChiTietServiceImplement;
import com.example.services.implement.GioHangServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/cart", "/add-cart", "/cart-delete"})
public class GioHangServlet extends HttpServlet {

    private GioHangChiTietService gioHangChiTietService = new GioHangChiTietServiceImplement();

    private GioHangService gioHangService = new GioHangServiceImplement();

    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("cart-delete")) {
            delete(request, response);
        } else {
            HttpSession session = request.getSession();
            KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
            if (khachHang == null) {
                // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
                response.sendRedirect("/Assignment_war_exploded/login");
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
            request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
            return;
        }

        try {
            String idSP = request.getParameter("id");
            String idGH = gioHangService.getById(khachHang.getId());
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            float giaBan = chiTietSPService.getGiaBanById(idSP);

            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setId(idSP);

            GioHang gioHang = new GioHang();
            gioHang.setId(idGH);

            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet(gioHang, chiTietSP, soLuong, giaBan);
            gioHangChiTietService.insert(gioHangChiTiet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Assignment_war_exploded/cart");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");

        try {
            String idSP = request.getParameter("id");
            String idGH = gioHangService.getById(khachHang.getId());

            gioHangChiTietService.delete(idSP, idGH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Assignment_war_exploded/cart");
    }

}
