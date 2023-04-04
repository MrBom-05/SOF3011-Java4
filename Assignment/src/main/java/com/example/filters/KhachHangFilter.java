package com.example.filters;

import com.example.entities.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/cart", "/cart-add", "/cart-delete", "/cart-update",
        "/bill", "/bill-add", "/bill-update", "/bill-all", "/bill-detail",
})
public class KhachHangFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        HttpSession session = servletRequest.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");

        if (khachHang == null) {
            servletResponse.sendRedirect("/Assignment_war_exploded/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
