package com.example.controllers.admin;

import com.example.entities.CuaHang;
import com.example.services.CuaHangService;
import com.example.services.implement.CuaHangServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.UUID;

@WebServlet({"/admin/cua-hang/index", "/admin/cua-hang/create", "/admin/cua-hang/edit", "/admin/cua-hang/delete", "/admin/cua-hang/update", "/admin/cua-hang/store"})
public class CuaHangServlet extends HttpServlet {

    private CuaHangService cuaHangService = new CuaHangServiceImplement();

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
            response.sendRedirect("/Assignment_war_exploded/admin/cua-hang/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean check = (Boolean) session.getAttribute("check");
        if (check == null){
            check = true;
        }
        request.setAttribute("check", check);

        Boolean checkUnique = (Boolean) session.getAttribute("checkUnique");
        if (checkUnique == null){
            checkUnique = true;
        }
        request.setAttribute("checkUnique", checkUnique);

        request.setAttribute("list", cuaHangService.getListCuaHang());

        request.setAttribute("view", "/views/admin/cua-hang/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/admin/cua-hang/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));

        CuaHang cuaHang = cuaHangService.getById(id);
        request.setAttribute("cuaHang", cuaHang);

        request.setAttribute("view", "/views/admin/cua-hang/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UUID id = UUID.fromString(request.getParameter("id"));
            boolean check = cuaHangService.delete(id);
            HttpSession session = request.getSession();
            session.setAttribute("check", check);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/cua-hang/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CuaHang cuaHang = new CuaHang();
            BeanUtils.populate(cuaHang, request.getParameterMap());
            boolean checkUnique = cuaHangService.insert(cuaHang);
            HttpSession session = request.getSession();
            session.setAttribute("checkUnique", checkUnique);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/cua-hang/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UUID id = UUID.fromString(request.getParameter("id"));

            CuaHang cuaHang = new CuaHang();
            BeanUtils.populate(cuaHang, request.getParameterMap());
            cuaHangService.update(id, cuaHang);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/cua-hang/index");
    }
}
