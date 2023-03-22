package com.example.controllers.user;

import com.example.entities.GioHang;
import com.example.entities.KhachHang;
import com.example.services.GioHangService;
import com.example.services.KhachHangService;
import com.example.services.implement.GioHangServiceImplement;
import com.example.services.implement.KhachHangServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({"/login", "/sign-up"})
public class LoginServlet extends HttpServlet {

    private KhachHangService khachHangService = new KhachHangServiceImplement();

    private GioHangService gioHangService = new GioHangServiceImplement();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("sign-up")) {
            request.getRequestDispatcher("/views/user/sign-up.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("sign-up")) {
            signUp(request, response);
        } else if (uri.contains("login")) {
            login(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String matKhau = request.getParameter("password");
        KhachHang khachHang = khachHangService.login(email, matKhau);
        if (khachHang != null) {
            boolean check = gioHangService.check(khachHang.getId());
            if (check == false){
                GioHang gioHang = new GioHang();
                gioHang.setMa(email);
                gioHang.setKhachHang(khachHang);
                gioHang.setTrangThai(1);
                gioHangService.insert(gioHang);
            }

            HttpSession session = request.getSession();
            session.setAttribute("khachHang", khachHang);
            request.setAttribute("view", "/views/user/home.jsp");
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("error", "Email hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
        }
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) {

    }
}
