package com.example.controllers.admin;

import com.example.entities.MauSac;
import com.example.services.MauSacService;
import com.example.services.implement.MauSacServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({"/admin/mau-sac/index", "/admin/mau-sac/create", "/admin/mau-sac/edit", "/admin/mau-sac/delete", "/admin/mau-sac/update", "/admin/mau-sac/store"})
public class MauSacServlet extends HttpServlet {

    private MauSacService mauSacService = new MauSacServiceImplement();

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
            response.sendRedirect("/Assignment_war_exploded/admin/mau-sac/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", mauSacService.getListMauSac());

        request.setAttribute("view", "/views/admin/mau-sac/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/admin/mau-sac/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        MauSac mauSac = mauSacService.getById(id);
        request.setAttribute("mauSac", mauSac);

        request.setAttribute("view", "/views/admin/mau-sac/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            mauSacService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/mau-sac/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MauSac mauSac = new MauSac();
            BeanUtils.populate(mauSac, request.getParameterMap());
            mauSacService.insert(mauSac);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/mau-sac/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");

            MauSac mauSac = new MauSac();
            BeanUtils.populate(mauSac, request.getParameterMap());
            mauSacService.update(id, mauSac);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/mau-sac/index");
    }
}
