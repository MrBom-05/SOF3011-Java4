<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 4/1/2023
  Time: 3:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="col-8 offset-2">
    <h4>Thông Tin Hóa Đơn</h4>
    <h6 class="mt-3">Mã Đơn Hàng: ${hoaDon.ma}</h6>
    <h6>Trạng Thái Đơn Hàng: ${hoaDon.trangThai}</h6>
    <h6>Tên Người Nhận: ${hoaDon.tenKH}</h6>
    <h6>Số Điện Thoại: ${hoaDon.sdt}</h6>
    <h6>Địa Chỉ: ${hoaDon.diaChi}</h6>
    <c:if test="${ f:length(list) == 0 }">
        <h4 class="text-center">Không có sản phẩm</h4>
    </c:if>
    <c:if test="${ f:length(list) != 0 }">
        <c:forEach var="sanPham" items="${ list }" varStatus="status">
            <div class="card mb-2 border">
                <div class="card-body">
                    <div class="row align-items-center">
                        <div class="col-1">
                            <img src="${sanPham.anh}" class="img-fluid d-flex" alt="Ảnh sản phẩm">
                        </div>
                        <div class="col-3">
                            <a href="/Assignment_war_exploded/product-detail?id=${sanPham.id}"
                               class="text-decoration-none text-black" scroll-to-top>${sanPham.ten}</a>
                        </div>
                        <div class="col-2">
                            <a class="text-decoration-none text-black">${sanPham.mauSac}</a>
                        </div>

                        <div class="col-2">
                            <span class="text-center text-truncate">$${sanPham.giaBan}</span>
                        </div>

                        <div class="col-2">
                            <span class="text-center text-truncate">${sanPham.soLuong}</span>
                        </div>
                        <div class="col-2">
                            <span class="text-center text-truncate text-danger">$${sanPham.giaBan * sanPham.soLuong}</span>
                        </div>
                    </div>
                </div>

            </div>
        </c:forEach>
    </c:if>
    <h6 class="mt-3">Tổng Tiền: $${hoaDon.tongTien}</h6>
    <c:if test="${hoaDon.trangThai eq 'Chưa Thanh Toán'}">
        <div class="row mt-5">
            <a type="button" class="btn btn-success mt-4 col-4 offset-4" href="/Assignment_war_exploded/bill-update?id=${hoaDon.id}&trangThai=4">Hủy Đơn Hàng</a>
        </div>
    </c:if>

    <c:if test="${hoaDon.trangThai eq 'Đã Ship'}">
        <div class="row mt-5">
            <a type="button" class="btn btn-danger mt-4 col-4 offset-4" href="/Assignment_war_exploded/bill-update?id=${hoaDon.id}&trangThai=2">Đã Nhận</a>
        </div>
    </c:if>
</div>