package com.example.controllers.admin;

import com.example.entities.SanPham;
import com.example.services.SanPhamService;
import com.example.services.implement.SanPhamServiceImplement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@WebServlet({"/admin/san-pham/index", "/admin/san-pham/create", "/admin/san-pham/edit", "/admin/san-pham/delete", "/admin/san-pham/update", "/admin/san-pham/store"})
public class SanPhamServlet extends HttpServlet {

    private SanPhamService sanPhamService = new SanPhamServiceImplement();


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
            response.sendRedirect("/Assignment_war_exploded/admin/san-pham/index");
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

        List<SanPham> list = sanPhamService.getListSanPham();

        String realPath = request.getServletContext().getRealPath("/images");

        // Thay đổi đường dẫn tới ảnh để hiển thị ảnh thay vì đường dẫn
        for (SanPham sanPham : list) {
            String fileName = sanPham.getAnh();
            if (fileName != null) {
                sanPham.setAnh(request.getContextPath() + "/images/" + fileName);
            }
        }


        request.setAttribute("list", list);
        request.setAttribute("view", "/views/admin/san-pham/index.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/admin/san-pham/create.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));

        SanPham sanPham = sanPhamService.getById(id);
        request.setAttribute("sanPham", sanPham);

        request.setAttribute("view", "/views/admin/san-pham/update.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UUID id = UUID.fromString(request.getParameter("id"));
            boolean check = sanPhamService.delete(id);
            HttpSession session = request.getSession();
            session.setAttribute("check", check);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/san-pham/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Part part = request.getPart("anh");
            String realPath = request.getServletContext().getRealPath("/images");
            String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectories(Path.of(realPath));
            }
            part.write(realPath + "/" + fileName);
            try {
                request.setAttribute("anh", fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }

            SanPham sanPham = new SanPham();
            sanPham.setAnh(fileName);
            BeanUtils.populate(sanPham, request.getParameterMap());

            boolean checkUnique = sanPhamService.insert(sanPham);
            HttpSession session = request.getSession();
            session.setAttribute("checkUnique", checkUnique);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/san-pham/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UUID id = UUID.fromString(request.getParameter("id"));

            Part part = request.getPart("anh");
            String realPath = request.getServletContext().getRealPath("/images");
            String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectories(Path.of(realPath));
            }
            part.write(realPath + "/" + fileName);
            try {
                request.setAttribute("anh", fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }

            SanPham sanPham = new SanPham();
            sanPham.setAnh(fileName);
//            BeanUtils.populate(sanPham, request.getParameterMap());
            sanPham.setTen(request.getParameter("ten"));
            sanPhamService.update(id, sanPham);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/admin/san-pham/index");
    }
}
