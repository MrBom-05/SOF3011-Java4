<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/10/2023
  Time: 2:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Danh Sách Khách Hàng</title>
    <link rel="stylesheet" href="/BaiTapSOF3011_war_exploded/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="col-10 offset-1 mt-3">
    <a href="/BaiTapSOF3011_war_exploded/khachhang/create" class="btn btn-success">Add Khách Hàng</a>

    <c:if test="${ f:length(khachHang) == 0 }">
        <h3 class="text-center">Không có dữ liệu</h3>
    </c:if>

    <c:if test="${ f:length(khachHang) != 0 }">
        <table class="table mt-5">
            <thead>
            <tr>
                <th>STT</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Tên Đệm</th>
                <th>Họ</th>
                <th>Ngày Sinh</th>
                <th>Số Điện Thoại</th>
                <th>Địa Chỉ</th>
                <th>Thành Phố</th>
                <th>Quốc Gia</th>
                <th>Email</th>
                <th>Mật Khẩu</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="khachHang" items="${ khachHang }">
                <tr>
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

                    <td>
                        <a href="/IT17202/admin/sinh-vien/edit?id=${ sv.id }" class="btn btn-primary">Cập nhật</a>
                        <a href="/IT17202/admin/sinh-vien/delete?id=${ sv.id }" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/popper.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>