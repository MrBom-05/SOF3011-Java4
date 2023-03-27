package com.example.controllers.admin;

import com.example.entities.*;
import com.example.services.*;
import com.example.services.implement.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({"/admin/chi-tiet-sp/index", "/admin/chi-tiet-sp/create", "/admin/chi-tiet-sp/edit", "/admin/chi-tiet-sp/delete", "/admin/chi-tiet-sp/update", "/admin/chi-tiet-sp/store"})
public class ChiTietSPServlet extends HttpServlet {

    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImplement();
    private SanPhamService sanPhamService = new SanPhamServiceImplement();
    private MauSacService mauSacService = new MauSacServiceImplement();
    private NSXService nsxService = new NSXServiceImplement();
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
            response.sendRedirect("/Assignment_war_exploded/admin/chi-tiet-sp/index");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean check = (Boolean) session.getAttribute("check");
        if (check == null){
            check = true;
        }
        request.setAttribute("check", check);

        request.setAttribute("list", chiTietSPService.getListChiTietSP());

        request.setAttribute("view", "/views/admin/chi-tiet-sp/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSanPham", sanPhamService.getListSanPham());
        request.setAttribute("listMauSac", mauSacService.getListMauSac());
        request.setAttribute("listNSX", nsxService.getListNSX());
        request.setAttribute("listDongSP", dongSPService.getListDongSP());

        request.setAttribute("view", "/views/admin/chi-tiet-sp/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSanPham", sanPhamService.getListSanPham());
        request.setAttribute("listMauSac", mauSacService.getListMauSac());
        request.setAttribute("listNSX", nsxService.getListNSX());
        request.setAttribute("listDongSP", dongSPService.getListDongSP());


        String id = request.getParameter("id");

        request.setAttribute("idSanPham", chiTietSPService.getIdSanPhamById(id));
        request.setAttribute("idMauSac", chiTietSPService.getIdMauSacById(id));
        request.setAttribute("idDongSP", chiTietSPService.getIdDongSPById(id));
        request.setAttribute("idNSX", chiTietSPService.getIdNSXById(id));

        ChiTietSP chiTietSP = chiTietSPService.getById(id);
        request.setAttribute("chiTietSP", chiTietSP);

        request.setAttribute("view", "/views/admin/chi-tiet-sp/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            boolean check = chiTietSPService.delete(id);
            HttpSession session = request.getSession();
            session.setAttribute("check", check);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chi-tiet-sp/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy các id từ thẻ select bên JSP
            SanPham sanPham = new SanPham();
            sanPham.setId(request.getParameter("idSanPham"));

            MauSac mauSac = new MauSac();
            mauSac.setId(request.getParameter("idMauSac"));

            DongSP dongSP = new DongSP();
            dongSP.setId(request.getParameter("idDongSP"));

            NSX nsx = new NSX();
            nsx.setId(request.getParameter("idNSX"));

            // Gán các đối tượng được setID vào đối tượng muốn thêm
            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setSanPham(sanPham);
            chiTietSP.setMauSac(mauSac);
            chiTietSP.setDongSP(dongSP);
            chiTietSP.setNsx(nsx);

            BeanUtils.populate(chiTietSP, request.getParameterMap());
            chiTietSPService.insert(chiTietSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chi-tiet-sp/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            // Lấy các id từ thẻ select bên JSP
            SanPham sanPham = new SanPham();
            sanPham.setId(request.getParameter("idSanPham"));

            MauSac mauSac = new MauSac();
            mauSac.setId(request.getParameter("idMauSac"));

            DongSP dongSP = new DongSP();
            dongSP.setId(request.getParameter("idDongSP"));

            NSX nsx = new NSX();
            nsx.setId(request.getParameter("idNSX"));

            // Gán các đối tượng được setID vào đối tượng muốn thêm
            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setSanPham(sanPham);
            chiTietSP.setMauSac(mauSac);
            chiTietSP.setDongSP(dongSP);
            chiTietSP.setNsx(nsx);

            BeanUtils.populate(chiTietSP, request.getParameterMap());
            chiTietSPService.update(id, chiTietSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/chi-tiet-sp/index");
    }
}
