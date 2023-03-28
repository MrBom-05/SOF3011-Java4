package com.example.controllers.admin;

import com.example.entities.ChucVu;
import com.example.services.ChucVuService;
import com.example.services.implement.ChucVuServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.UUID;

@WebServlet({"/admin/chuc-vu/index", "/admin/chuc-vu/create", "/admin/chuc-vu/edit", "/admin/chuc-vu/delete", "/admin/chuc-vu/update", "/admin/chuc-vu/store"})
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
            response.sendRedirect("/Assignment_war_exploded/admin/chuc-vu/index");
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
        request.setAttribute("list", chucVuService.getListChucVu());
        request.setAttribute("view", "/views/admin/chuc-vu/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/admin/chuc-vu/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));

        ChucVu chucVu = chucVuService.getById(id);
        request.setAttribute("chucVu", chucVu);

        request.setAttribute("view", "/views/admin/chuc-vu/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UUID id = UUID.fromString(request.getParameter("id"));
            boolean check = chucVuService.delete(id);
            HttpSession session = request.getSession();
            session.setAttribute("check", check);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chuc-vu/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ChucVu chucVu = new ChucVu();
            BeanUtils.populate(chucVu, request.getParameterMap());
            boolean checkUnique = chucVuService.insert(chucVu);
            HttpSession session = request.getSession();
            session.setAttribute("checkUnique", checkUnique);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chuc-vu/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UUID id = UUID.fromString(request.getParameter("id"));

            ChucVu chucVu = new ChucVu();
            BeanUtils.populate(chucVu, request.getParameterMap());

            chucVuService.update(id, chucVu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chuc-vu/index");
    }
}


