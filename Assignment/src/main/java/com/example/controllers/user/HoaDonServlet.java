package com.example.controllers.user;

import com.example.entities.ChiTietSP;
import com.example.entities.HoaDon;
import com.example.entities.HoaDonChiTiet;
import com.example.entities.KhachHang;
import com.example.models.GioHangChiTietCustom;
import com.example.models.HoaDonChiTietCustom;
import com.example.models.HoaDonUserCustom;
import com.example.services.*;
import com.example.services.implement.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@WebServlet({"/bill", "/bill-add", "/bill-update", "/bill-all", "/bill-detail"})
public class HoaDonServlet extends HttpServlet {

    private HoaDonService hoaDonService = new HoaDonServiceImplement();

    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImplement();

    private GioHangService gioHangService = new GioHangServiceImplement();

    private GioHangChiTietService gioHangChiTietService = new GioHangChiTietServiceImplement();

    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("bill-add")) {
            insert(request, response);
        } else if (uri.contains("bill-update")) {
            update(request, response);
        } else if (uri.contains("bill-all")) {
            insertAll(request, response);
        } else if (uri.contains("bill-detail")) {
            getBillDetail(request, response);
        } else {
            getListBill(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private Date getDateNow() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }

    private void getListBill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
            response.sendRedirect("/Assignment_war_exploded/login");
            return;
        }

        List<HoaDonUserCustom> list = hoaDonService.getListHoaDonByUser(khachHang.getId());

        if (khachHang != null) {
            request.setAttribute("index", gioHangChiTietService.index(khachHang.getId()));
            // Tiếp tục thực hiện đoạn code của bạn ở đây
        } else {
            // Xử lý trường hợp khachHang là null ở đây (ví dụ: ghi log, trả về lỗi, ...)
            request.setAttribute("index", 0);
        }

        request.setAttribute("list", list);

        request.setAttribute("view", "/views/user/bill.jsp");
        request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
    }

    private void getBillDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
            response.sendRedirect("/Assignment_war_exploded/login");
            return;
        }


        if (khachHang != null) {
            request.setAttribute("index", gioHangChiTietService.index(khachHang.getId()));
            // Tiếp tục thực hiện đoạn code của bạn ở đây
        } else {
            // Xử lý trường hợp khachHang là null ở đây (ví dụ: ghi log, trả về lỗi, ...)
            request.setAttribute("index", 0);
        }

        UUID idHD = UUID.fromString(request.getParameter("id"));

        request.setAttribute("hoaDon", hoaDonService.getByID(idHD));

        List<HoaDonChiTietCustom> list = hoaDonChiTietService.getListByID(idHD);
        for (HoaDonChiTietCustom hoaDonChiTietCustom : list) {
            String fileName = hoaDonChiTietCustom.getAnh();
            if (fileName != null) {
                hoaDonChiTietCustom.setAnh(request.getContextPath() + "/images/" + fileName);
            }
        }

        request.setAttribute("list", list);

        request.setAttribute("view", "/views/user/bill-detail.jsp");
        request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
            response.sendRedirect("/Assignment_war_exploded/login");
            return;
        }

        try {
            // Tạo mã ngẫu nhiên cho hóa đơn
            Random random = new Random();
            int pass = random.nextInt(10000) + 1;

            // Tạo đối tượng hóa đơn
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMa(String.valueOf(pass));
            hoaDon.setKhachHang(khachHang);
            hoaDon.setNgayTao(getDateNow());

            // Thêm hóa đơn và lấy ra id của hoá đơn đó
            UUID idHD = hoaDonService.insert(hoaDon);
            // Lấy id sản phẩm từ uri
            UUID idSP = UUID.fromString(request.getParameter("id"));
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            // Lấy giá sản phẩm
            BigDecimal giaBan = chiTietSPService.getGiaBanById(idSP);

            // Tạo đối tượng sản phẩm để thêm vào hóa đơn chi tiết
            HoaDon hoaDonCT = new HoaDon();
            hoaDonCT.setId(idHD);
            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setId(idSP);

            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDonCT, chiTietSP, soLuong, giaBan);
            hoaDonChiTietService.insert(hoaDonChiTiet);

            // Xóa sản phẩm đó khỏi giỏ hàng
            UUID idGH = gioHangService.getById(khachHang.getId());
            gioHangChiTietService.deleteOne(idSP, idGH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/bill");
    }


    private void insertAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
            response.sendRedirect("/Assignment_war_exploded/login");
            return;
        }

        try {
            Random random = new Random();
            int pass = random.nextInt(10000) + 1;

            HoaDon hoaDon = new HoaDon();
            hoaDon.setMa(String.valueOf(pass));
            hoaDon.setKhachHang(khachHang);
            hoaDon.setNgayTao(getDateNow());

            UUID idHD = hoaDonService.insert(hoaDon);


            List<GioHangChiTietCustom> list = gioHangChiTietService.getList(khachHang.getId());

            for (GioHangChiTietCustom gioHangChiTietCustom : list) {

                HoaDon hoaDonCT = new HoaDon();
                hoaDonCT.setId(idHD);

                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(gioHangChiTietCustom.getId());

                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDonCT, chiTietSP, gioHangChiTietCustom.getSoLuong(), gioHangChiTietCustom.getGiaBan());
                hoaDonChiTietService.insert(hoaDonChiTiet);
            }
            gioHangChiTietService.deleteAll(gioHangService.getById(khachHang.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Assignment_war_exploded/bill");

//        1. Lấy thông tin khách hàng từ session.
//        2. Kiểm tra nếu khách hàng chưa đăng nhập thì yêu cầu họ đăng nhập.
//        3. Tạo một mã ngẫu nhiên cho đơn hàng.
//        4. Tạo một đối tượng hóa đơn và thiết lập các thuộc tính của nó, bao gồm mã đơn hàng và khách hàng.
//        5. Thêm đơn hàng vào cơ sở dữ liệu và lấy ra ID của đơn hàng vừa được thêm.
//        6. Lấy danh sách các sản phẩm trong giỏ hàng của khách hàng.
//        7. Duyệt qua danh sách sản phẩm và tạo một đối tượng hóa đơn chi tiết cho mỗi sản phẩm đó,
//        bao gồm thông tin về đơn hàng, sản phẩm, số lượng và giá bán.
//        8. Thêm hóa đơn chi tiết vào cơ sở dữ liệu.
//        9. Xóa tất cả các sản phẩm trong giỏ hàng của khách hàng.
//        10. Chuyển hướng khách hàng đến trang giỏ hàng.
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            // Nếu chưa đăng nhập, yêu cầu người dùng đăng nhập
            response.sendRedirect("/Assignment_war_exploded/login");
            return;
        }


        if (khachHang != null) {
            request.setAttribute("index", gioHangChiTietService.index(khachHang.getId()));
            // Tiếp tục thực hiện đoạn code của bạn ở đây
        } else {
            // Xử lý trường hợp khachHang là null ở đây (ví dụ: ghi log, trả về lỗi, ...)
            request.setAttribute("index", 0);
        }

        try {
            UUID idHD = UUID.fromString(request.getParameter("id"));
            int trangThai = Integer.parseInt(request.getParameter("trangThai"));


            if (trangThai == 4){
                hoaDonService.updateHoaDonNgayShip(idHD, 4, null);
                // Hủy Hóa Đơn
            } else {
                hoaDonService.updateHoaDonNgayNhan(idHD, 2, getDateNow());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/Assignment_war_exploded/bill");
    }
}
