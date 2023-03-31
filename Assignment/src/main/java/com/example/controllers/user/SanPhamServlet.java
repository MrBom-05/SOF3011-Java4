package com.example.controllers.user;

import com.example.entities.KhachHang;
import com.example.models.SanPhamChiTietCustom;
import com.example.models.SanPhamCustom;
import com.example.services.ChiTietSPService;
import com.example.services.GioHangChiTietService;
import com.example.services.implement.ChiTietSPServiceImplement;
import com.example.services.implement.GioHangChiTietServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/product-detail"
})
public class SanPhamServlet extends HttpServlet {

    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImplement();

    private GioHangChiTietService gioHangChiTietService = new GioHangChiTietServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));

        SanPhamChiTietCustom sanPhamChiTietCustom = chiTietSPService.getProductById(id);

        String realPath = request.getServletContext().getRealPath("/images");

        // Thay đổi đường dẫn tới ảnh để hiển thị ảnh thay vì đường dẫn

        String fileName = sanPhamChiTietCustom.getAnh();
        if (fileName != null) {
            sanPhamChiTietCustom.setAnh(request.getContextPath() + "/images/" + fileName);
        }



        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");

        if (khachHang != null) {
            request.setAttribute("index", gioHangChiTietService.index(khachHang.getId()));
            // Tiếp tục thực hiện đoạn code của bạn ở đây
        } else {
            // Xử lý trường hợp khachHang là null ở đây (ví dụ: ghi log, trả về lỗi, ...)
            request.setAttribute("index", 0);
        }
        request.setAttribute("sanPham", sanPhamChiTietCustom);

        request.setAttribute("view", "/views/user/product-detail.jsp");
        request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
    }
}
