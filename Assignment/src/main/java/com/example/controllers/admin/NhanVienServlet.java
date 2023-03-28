package com.example.controllers.admin;

import com.example.entities.ChucVu;
import com.example.entities.CuaHang;
import com.example.entities.NhanVien;
import com.example.services.ChucVuService;
import com.example.services.CuaHangService;
import com.example.services.NhanVienService;
import com.example.services.implement.ChucVuServiceImplement;
import com.example.services.implement.CuaHangServiceImplement;
import com.example.services.implement.NhanVienServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet({"/admin/nhan-vien/index", "/admin/nhan-vien/create", "/admin/nhan-vien/edit", "/admin/nhan-vien/delete", "/admin/nhan-vien/update", "/admin/nhan-vien/store"})
public class NhanVienServlet extends HttpServlet {

    private NhanVienService nhanVienService = new NhanVienServiceImplement();
    private CuaHangService cuaHangService = new CuaHangServiceImplement();
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
            response.sendRedirect("/Assignment_war_exploded/admin/nhan-vien/index");
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

        request.setAttribute("list", nhanVienService.getListNhanVien());

        request.setAttribute("view", "/views/admin/nhan-vien/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCuaHang", cuaHangService.getListCuaHang());
        request.setAttribute("listChucVu", chucVuService.getListChucVu());

        request.setAttribute("view", "/views/admin/nhan-vien/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCuaHang", cuaHangService.getListCuaHang());
        request.setAttribute("listChucVu", chucVuService.getListChucVu());

        String ma = request.getParameter("ma");

        request.setAttribute("idCuaHang", nhanVienService.getIdCuaHangByMa(ma));
        request.setAttribute("idChucVu", nhanVienService.getIdChucVuByMa(ma));

        NhanVien nhanVien = nhanVienService.getByMa(ma);
        request.setAttribute("nhanVien", nhanVien);

        request.setAttribute("view", "/views/admin/nhan-vien/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            boolean check = nhanVienService.delete(ma);
            HttpSession session = request.getSession();
            session.setAttribute("check", check);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/nhan-vien/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Định dạng năm tháng ngày
            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateTimeConverter, Date.class);

            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(UUID.fromString(request.getParameter("idCuaHang")));

            ChucVu chucVu = new ChucVu();
            chucVu.setId(UUID.fromString(request.getParameter("idChucVu")));

            NhanVien nhanVien = new NhanVien();
            nhanVien.setCuaHang(cuaHang);
            nhanVien.setChucVu(chucVu);
            BeanUtils.populate(nhanVien, request.getParameterMap());
            boolean checkUnique = nhanVienService.insert(nhanVien);
            HttpSession session = request.getSession();
            session.setAttribute("checkUnique", checkUnique);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/nhan-vien/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");

            // Định dạng năm tháng ngày
            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateTimeConverter, Date.class);

            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(UUID.fromString(request.getParameter("idCuaHang")));

            ChucVu chucVu = new ChucVu();
            chucVu.setId(UUID.fromString(request.getParameter("idChucVu")));

            NhanVien nhanVien = new NhanVien();
            nhanVien.setCuaHang(cuaHang);
            nhanVien.setChucVu(chucVu);
            BeanUtils.populate(nhanVien, request.getParameterMap());
            nhanVienService.update(ma, nhanVien);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/nhan-vien/index");
    }
}
