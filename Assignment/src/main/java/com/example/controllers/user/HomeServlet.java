package com.example.controllers.user;

import com.example.models.SanPhamCustom;
import com.example.services.ChiTietSPService;
import com.example.services.implement.ChiTietSPServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/home"
})
public class HomeServlet extends HttpServlet {

    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPhamCustom> list = chiTietSPService.getListSP();

        String realPath = request.getServletContext().getRealPath("/images");

        // Thay đổi đường dẫn tới ảnh để hiển thị ảnh thay vì đường dẫn
        for (SanPhamCustom sanPhamCustom : list) {
            String fileName = sanPhamCustom.getAnh();
            if (fileName != null) {
                sanPhamCustom.setAnh(request.getContextPath() + "/images/" + fileName);
            }
        }

        request.setAttribute("list", list);

        request.setAttribute("view", "/views/user/product.jsp");
        request.setAttribute("banner", "/views/user/banner.jsp");
        request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
