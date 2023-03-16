<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Danh sách</title>
    <link rel="stylesheet" href="/Assignment_war_exploded/bootstrap/css/bootstrap.min.css">
</head>
<body class="col-10 offset-1">

<h2 class="mt-3">Quản Lý Khách Hàng</h2>

<a href="/Assignment_war_exploded/admin/khach-hang/create" class="btn btn-success mt-3">Add</a>

<c:if test="${ f:length(list) == 0 }">
    <h4 class="text-center">Không có dữ liệu</h4>
</c:if>

<c:if test="${ f:length(list) != 0 }">

    <table class="table table-bordered mt-5">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên Đệm</th>
            <th>Họ</th>
            <th>Ngày Sinh</th>
            <th>SDT</th>
            <th>Địa Chỉ</th>
            <th>Thành Phố</th>
            <th>Quốc Gia</th>
            <th>Email</th>
            <th>Mật Khẩu</th>
            <th class="col-2 text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="khachHang" items="${ list }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ khachHang.ma }</td>
                <td>${ khachHang.ten }</td>
                <td>${ khachHang.tenDem }</td>
                <td>${ khachHang.ho }</td>
                <td>${ khachHang.ngaySinh }</td>
                <td>${ khachHang.sdt }</td>
                <td>${ khachHang.diaChi }</td>
                <td>${ khachHang.thanhPho }</td>
                <td>${ khachHang.quocGia }</td>
                <td>${ khachHang.email }</td>
                <td>${ khachHang.matKhau }</td>

                <td class="text-center">
                    <a href="/Assignment_war_exploded/admin/khach-hang/edit?id=${ khachHang.id }"
                       class="btn btn-primary">Update</a>
                    <a href="/Assignment_war_exploded/admin/khach-hang/delete?id=${ khachHang.id }"
                       class="btn btn-danger">Delete</a>
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
