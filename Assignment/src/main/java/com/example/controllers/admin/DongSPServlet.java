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
        request.getRequestDispatcher("/views/admin/dong-sp/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/dong-sp/create.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/dong-sp/update.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    }
}

