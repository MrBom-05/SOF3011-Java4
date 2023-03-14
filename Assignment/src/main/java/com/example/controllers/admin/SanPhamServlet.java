package com.example.controllers.admin;

import com.example.entities.SanPham;
import com.example.services.SanPhamService;
import com.example.services.implement.SanPhamServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/admin/san-pham/index",
        "/admin/san-pham/create",
        "/admin/san-pham/edit",
        "/admin/san-pham/delete",
        "/admin/san-pham/update",
        "/admin/san-pham/store"
})
public class SanPhamServlet extends HttpServlet {

    private SanPhamService sanPhamService = new SanPhamServiceImplement();


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
            response.sendRedirect("/Assignment_war_exploded/admin/san-pham/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> list = sanPhamService.getListSanPham();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/admin/san-pham/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/san-pham/create.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/san-pham/update.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SanPham sanPham = new SanPham();
            BeanUtils.populate(sanPham, request.getParameterMap());
            sanPhamService.insert(sanPham);
        } catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/san-pham/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
