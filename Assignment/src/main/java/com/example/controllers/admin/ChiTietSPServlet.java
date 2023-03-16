package com.example.controllers.admin;

import com.example.entities.*;
import com.example.models.ChiTietSPCustom;
import com.example.services.*;
import com.example.services.implement.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/chi-tiet-sp/index", "/admin/chi-tiet-sp/create", "/admin/chi-tiet-sp/edit", "/admin/chi-tiet-sp/delete", "/admin/chi-tiet-sp/update", "/admin/chi-tiet-sp/store"})
public class ChiTietSPServlet extends HttpServlet {

    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImplement();
    private SanPhamService sanPhamService = new SanPhamServiceImplement();
    private MauSacService mauSacService = new MauSacServiceImplement();
    private NSXService nsxService = new NSXServiceImplement();
    private DongSPService dongSPService = new DongSPServiceImplement();

    List<SanPham> listSanPham = sanPhamService.getListSanPham();
    List<MauSac> listMauSac = mauSacService.getListMauSac();
    List<NSX> listNSX = nsxService.getListNSX();
    List<DongSP> listDongSP = dongSPService.getListDongSP();

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
        List<ChiTietSPCustom> list = chiTietSPService.getListChiTietSP();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/admin/chi-tiet-sp/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listMauSac", listMauSac);
        request.setAttribute("listNSX", listNSX);
        request.setAttribute("listDongSP", listDongSP);
        request.getRequestDispatcher("/views/admin/chi-tiet-sp/create.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listMauSac", listMauSac);
        request.setAttribute("listNSX", listNSX);
        request.setAttribute("listDongSP", listDongSP);


        String id = request.getParameter("id");

        request.setAttribute("idSanPham", chiTietSPService.getIdSanPhamById(id));
        request.setAttribute("idMauSac", chiTietSPService.getIdMauSacById(id));
        request.setAttribute("idDongSP", chiTietSPService.getIdDongSPById(id));
        request.setAttribute("idNSX", chiTietSPService.getIdNSXById(id));

        ChiTietSP chiTietSP = chiTietSPService.getById(id);
        request.setAttribute("chiTietSP", chiTietSP);


        request.getRequestDispatcher("/views/admin/chi-tiet-sp/update.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            chiTietSPService.delete(id);
        } catch (Exception e){
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

    }
}
