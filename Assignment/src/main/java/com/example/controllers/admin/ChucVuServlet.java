package com.example.controllers.admin;

import com.example.entities.ChucVu;
import com.example.services.ChucVuService;
import com.example.services.implement.ChucVuServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/admin/chucvu/index",
        "/admin/chucvu/create",
        "/admin/chucvu/edit",
        "/admin/chucvu/delete",
        "/admin/chucvu/update",
        "/admin/chucvu/store"
})
public class ChucVuServlet extends HttpServlet {

    private ChucVuService chucVuService = new ChucVuServiceImplement();

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
            response.sendRedirect("/Assignment_war_exploded/admin/sinh-vien/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> list = chucVuService.getListChucVu();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/admin/chucvu/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/chucvu/create.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/chucvu/update.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        ChucVu chucVu = new ChucVu("", ma, ten);

        try {
            chucVuService.insert(chucVu);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Assignment_war_exploded/admin/chucvu/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


