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
import java.util.Date;
import java.util.Random;
import java.util.UUID;

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

        request.setAttribute("list", khachHangService.getListKhachHang());

        request.setAttribute("view", "/views/admin/khach-hang/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/admin/khach-hang/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));

        KhachHang khachHang = khachHangService.getById(id);
        request.setAttribute("khachHang", khachHang);

        request.setAttribute("view", "/views/admin/khach-hang/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UUID id = UUID.fromString(request.getParameter("id"));
            boolean check = khachHangService.delete(id);
            HttpSession session = request.getSession();
            session.setAttribute("check", check);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/khach-hang/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateTimeConverter, Date.class);

            Random random = new Random();
            int pass = random.nextInt(10000) + 1;

            KhachHang khachHang = new KhachHang();
            khachHang.setMa(String.valueOf(pass));
            BeanUtils.populate(khachHang, request.getParameterMap());
            boolean checkUnique = khachHangService.insert(khachHang);
            HttpSession session = request.getSession();
            session.setAttribute("checkUnique", checkUnique);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/khach-hang/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UUID id = UUID.fromString(request.getParameter("id"));

            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateTimeConverter, Date.class);

            KhachHang khachHang = new KhachHang();
            BeanUtils.populate(khachHang, request.getParameterMap());
            khachHangService.update(id, khachHang);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/khach-hang/index");
    }
}
