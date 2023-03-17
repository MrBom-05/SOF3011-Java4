<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Quản Lý Hóa Đơn</title>
    <link rel="stylesheet" href="/Assignment_war_exploded/bootstrap/css/bootstrap.min.css">
</head>
<body class="col-10 offset-1">
<h2 class="mt-3">Quản Lý Hóa Đơn</h2>

<c:if test="${ f:length(list) == 0 }">
    <h4 class="text-center">Không có dữ liệu</h4>
</c:if>

<c:if test="${ f:length(list) != 0 }">

    <table class="table table-bordered mt-5">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên Nhân Viên</th>
            <th>Tên Khách Hàng</th>
            <th>SDT Khách Hàng</th>
            <th>Địa Chỉ Khách Hàng</th>
            <th>Ngày Tạo</th>
            <th>Ngày Ship</th>
            <th>Ngày Nhận</th>
            <th>Ngày Thanh Toán</th>
            <th>Trạng Thái</th>
            <th class="col-1 text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="hoaDon" items="${ listHoaDon }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ hoaDon.ma }</td>
                <td>${ hoaDon.tenNV }</td>
                <td>${ hoaDon.tenKH }</td>
                <td>${ hoaDon.sdtKH }</td>
                <td>${ hoaDon.diaChiKH }</td>
                <td>${ hoaDon.ngayTao }</td>
                <td>${ hoaDon. ngayShip}</td>
                <td>${ hoaDon.ngayNhan }</td>
                <td>${ hoaDon.ngayThanhToan }</td>
                <td>${ hoaDon.trangThai }</td>

                <td class="text-center">
                    <a href="/Assignment_war_exploded/admin/hoa-don/detail?id=${ hoaDon.id }"
                       class="btn btn-danger">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<script src="/Assignment_war_exploded/bootstrap/js/jquery.min.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/popper.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
