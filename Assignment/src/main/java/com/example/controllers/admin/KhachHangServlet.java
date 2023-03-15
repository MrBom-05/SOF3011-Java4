package com.example.controllers.admin;

import com.example.entities.KhachHang;
import com.example.services.KhachHangService;
import com.example.services.implement.KhachHangServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet({"/admin/khach-hang/index", "/admin/khach-hang/create", "/admin/khach-hang/edit", "/admin/khach-hang/delete", "/admin/khach-hang/update", "/admin/khach-hang/store"})
public class KhachHangServlet extends HttpServlet {

    private KhachHangService khachHangService = new KhachHangServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("create")) {
            create(request, response);
        } else if (url.contains("edit")) {
            edit(request, response);
        } else if (url.contains("delete")) {
            delete(request, response);
        } else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            store(request, response);
        } else if (uri.contains("update")) {
            update(request, response);
        } else {
            response.sendRedirect("/Assignment_war_exploded/admin/khach-hang/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> list = khachHangService.getListKhachHang();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/admin/khach-hang/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/khach-hang/create.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/khach-hang/update.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DateTimeConverter dateTimeConverter = new DateConverter();
//            dateTimeConverter.setPattern("yyyy/MM/dd");
//            ConvertUtils.register(dateTimeConverter, Date.class);

            KhachHang khachHang = new KhachHang();
            BeanUtils.populate(khachHang, request.getParameterMap());
            khachHangService.insert(khachHang);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/khach-hang/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
