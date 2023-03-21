package com.example.controllers.user;

import com.example.models.ChiTietSPCustom;
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
        request.setAttribute("list", chiTietSPService.getListChiTietSP());

        request.setAttribute("view", "/views/user/product.jsp");
        request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
