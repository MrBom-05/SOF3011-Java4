package com.example.filters;

import com.example.entities.KhachHang;
import com.example.entities.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/admin/chi-tiet-sp/*",
        "/admin/chuc-vu/*",
        "/admin/cua-hang/*",
        "/admin/dong-sp/*",
        "/admin/hoa-don/*",
        "/admin/khach-hang/*",
        "/admin/mau-sac/*",
        "/admin/nhan-vien/*",
        "/admin/nsx/*",
        "/admin/san-pham/*",
        "/admin"
})
public class NhanVienFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        HttpSession session = servletRequest.getSession();
        NhanVien nhanVien = (NhanVien) session.getAttribute("nhanVien");

        if (nhanVien == null) {
            servletResponse.sendRedirect("/Assignment_war_exploded/admin/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
