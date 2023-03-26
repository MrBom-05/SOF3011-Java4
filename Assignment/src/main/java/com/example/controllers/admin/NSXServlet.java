package com.example.controllers.admin;

import com.example.entities.NSX;
import com.example.services.NSXService;
import com.example.services.implement.NSXServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({"/admin/nsx/index", "/admin/nsx/create", "/admin/nsx/edit", "/admin/nsx/delete", "/admin/nsx/update", "/admin/nsx/store"})
public class NSXServlet extends HttpServlet {

    private NSXService nsxService = new NSXServiceImplement();

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
            response.sendRedirect("/Assignment_war_exploded/admin/nsx/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", nsxService.getListNSX());

        request.setAttribute("view", "/views/admin/nsx/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/admin/nsx/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        NSX nsx = nsxService.getById(id);
        request.setAttribute("nsx", nsx);

        request.setAttribute("view", "/views/admin/nsx/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            boolean check = nsxService.delete(id);

            request.setAttribute("check", check);
            request.getRequestDispatcher("/admin/nsx/index").forward(request, response); // chuyển hướng trang với request và response hiện tại

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NSX nsx = new NSX();
            BeanUtils.populate(nsx, request.getParameterMap());
            nsxService.insert(nsx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/nsx/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");

            NSX nsx = new NSX();
            BeanUtils.populate(nsx, request.getParameterMap());
            nsxService.update(id, nsx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/nsx/index");
    }
}
