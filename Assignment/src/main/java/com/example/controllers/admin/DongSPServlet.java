package com.example.controllers.admin;

import com.example.entities.DongSP;
import com.example.services.DongSPService;
import com.example.services.implement.DongSPServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/dong-sp/index", "/admin/dong-sp/create", "/admin/dong-sp/edit", "/admin/dong-sp/delete", "/admin/dong-sp/update", "/admin/dong-sp/store"})
public class DongSPServlet extends HttpServlet {

    private DongSPService dongSPService = new DongSPServiceImplement();

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
            response.sendRedirect("/Assignment_war_exploded/admin/dong-sp/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DongSP> list = dongSPService.getListDongSP();
        request.setAttribute("list", list);

        request.setAttribute("view", "/views/admin/dong-sp/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/admin/dong-sp/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        DongSP dongSP = dongSPService.getById(id);
        request.setAttribute("dongSP", dongSP);

        request.setAttribute("view", "/views/admin/dong-sp/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            dongSPService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/dong-sp/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DongSP dongSP = new DongSP();
            BeanUtils.populate(dongSP, request.getParameterMap());
            dongSPService.insert(dongSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/dong-sp/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");

            DongSP dongSP = new DongSP();
            BeanUtils.populate(dongSP, request.getParameterMap());
            dongSPService.update(id, dongSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/dong-sp/index");
    }
}


