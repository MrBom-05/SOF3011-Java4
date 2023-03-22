package com.example.controllers.user;

import com.example.entities.KhachHang;
import com.example.models.SanPhamChiTietCustom;
import com.example.models.SanPhamCustom;
import com.example.services.ChiTietSPService;
import com.example.services.implement.ChiTietSPServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/product-detail"
})
public class SanPhamServlet extends HttpServlet {

    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SanPhamChiTietCustom sanPhamChiTietCustom = chiTietSPService.getProductById(id);

        String realPath = request.getServletContext().getRealPath("/images");

        // Thay đổi đường dẫn tới ảnh để hiển thị ảnh thay vì đường dẫn

        String fileName = sanPhamChiTietCustom.getAnh();
        if (fileName != null) {
            sanPhamChiTietCustom.setAnh(request.getContextPath() + "/images/" + fileName);
        }



//        List<SanPhamCustom> list = chiTietSPService.getListSP();
//        for (SanPhamCustom sanPhamCustom : list) {
//            String name = sanPhamCustom.getAnh();
//            if (name != null) {
//                sanPhamCustom.setAnh(request.getContextPath() + "/images/" + fileName);
//            }
//        }
//
//        request.setAttribute("list", list);
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
