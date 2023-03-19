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

<h2 class="mt-3">Quản Lý Nhân Viên</h2>

<a href="/Assignment_war_exploded/admin/nhan-vien/create" class="btn btn-success mt-3">Add</a>

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
            <th>Giới Tính</th>
            <th>Ngày Sinh</th>
            <th>SDT</th>
            <th>Địa Chỉ</th>
            <th>Cửa Hàng</th>
            <th>Chức Vụ</th>
            <th>Email</th>
            <th>Mật Khẩu</th>
            <th>Trạng Thái</th>
            <th class="col-2 text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="nhanVien" items="${ list }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ nhanVien.ma }</td>
                <td>${ nhanVien.ten }</td>
                <td>${ nhanVien.tenDem }</td>
                <td>${ nhanVien.ho }</td>
                <td>${ nhanVien.gioiTinh }</td>
                <td>${ nhanVien.ngaySinh }</td>
                <td>${ nhanVien.sdt }</td>
                <td>${ nhanVien.diaChi }</td>
                <td>${ nhanVien.cuaHang }</td>
                <td>${ nhanVien.chucVu }</td>
                <td>${ nhanVien.email }</td>
                <td>${ nhanVien.matKhau }</td>
                <td>${ nhanVien.trangThai == 1 ? "Đang Làm" : "Đã Nghỉ" }</td>

                <td class="text-center">
                    <a href="/Assignment_war_exploded/admin/nhan-vien/edit?ma=${ nhanVien.ma }"
                       class="btn btn-primary">Update</a>
                    <a href="/Assignment_war_exploded/admin/nhan-vien/delete?ma=${ nhanVien.ma }"
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
