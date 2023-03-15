package com.example.controllers.admin;

import com.example.entities.ChucVu;
import com.example.entities.CuaHang;
import com.example.models.NhanVienCustom;
import com.example.services.ChucVuService;
import com.example.services.CuaHangService;
import com.example.services.NhanVienService;
import com.example.services.implement.ChucVuServiceImplement;
import com.example.services.implement.CuaHangServiceImplement;
import com.example.services.implement.NhanVienServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/nhan-vien/index", "/admin/nhan-vien/create", "/admin/nhan-vien/edit", "/admin/nhan-vien/delete", "/admin/nhan-vien/update", "/admin/nhan-vien/store"})
public class NhanVienServlet extends HttpServlet {

    private NhanVienService nhanVienService = new NhanVienServiceImplement();
    private CuaHangService cuaHangService = new CuaHangServiceImplement();
    private ChucVuService chucVuService = new ChucVuServiceImplement();

    List<CuaHang> listCuaHang = cuaHangService.getListCuaHang();
    List<ChucVu> listChucVu = chucVuService.getListChucVu();

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
            response.sendRedirect("/Assignment_war_exploded/admin/nhan-vien/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVienCustom> list = nhanVienService.getListNhanVien();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/admin/nhan-vien/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCuaHang", listCuaHang);
        request.setAttribute("listChucVu", listChucVu);
        request.getRequestDispatcher("/views/admin/nhan-vien/create.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCuaHang", listCuaHang);
        request.setAttribute("listChucVu", listChucVu);
        request.getRequestDispatcher("/views/admin/nhan-vien/update.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
