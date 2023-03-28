<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<h2 class="mt-3 text-center">Thêm Mới Nhân Viên</h2>

<form class="row g-3 needs-validation col-10 offset-1 mt-3 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/nhan-vien/store" id="form">

    <div class="col-md-4">
        <label class="form-label">Tên<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="ten" required onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên Đệm<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="tenDem" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Họ<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="ho" required onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Ngày Sinh<span class="text-danger">*</span></label>
        <input type="date" class="form-control" name="ngaySinh" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">SDT<span class="text-danger">*</span></label>
        <input type="number" class="form-control" name="sdt" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Email<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="email" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Địa Chỉ<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="diaChi" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Cửa Hàng<span class="text-danger">*</span></label>
        <select class="form-select" name="idCuaHang">
            <option value="false" disabled selected>-- Chọn Của Hàng --</option>
            <c:forEach var="cuaHang" items="${listCuaHang}">
                <option value="${cuaHang.id}">${cuaHang.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label class="form-label">Chức Vụ<span class="text-danger">*</span></label>
        <select class="form-select" name="idChucVu">
            <option value="false" disabled selected>-- Chọn Chức Vụ --</option>
            <c:forEach var="chucVu" items="${listChucVu}">
                <option value="${chucVu.id}">${chucVu.ten}</option>
            </c:forEach>
        </select>
    </div>

    <div class="col-md-4">
        <label class="form-label">Mật Khẩu<span class="text-danger">*</span></label>
        <input type="password" class="form-control" name="matKhau" required
               onblur="validateRed(this)">
    </div>

    <div class="col-md-4">
        <label class="form-label">Mã<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="ma" required onblur="validateRed(this)">
    </div>

    <div class="col-md-4">
        <label class="form-label">Giới Tính</label>
        <div class="row mt-1">
            <div class="form-check col-6">
                <input class="form-check-input ms-5" value="Nam" type="radio" name="gioiTinh" checked
                       required>
                <label class="form-check-label ms-2">Nam</label>
            </div>
            <div class="form-check col-6">
                <input class="form-check-input" value="Nữ" type="radio" name="gioiTinh" required>
                <label class="form-check-label">Nữ</label>
            </div>
        </div>
    </div>

    <div class="col-md-4 offset-4">
        <label class="form-label">Trạng Thái<span class="text-danger">*</span></label>
        <select class="form-select" name="trangThai">
            <option value="false" disabled selected>-- Chọn Trạng Thái --</option>
            <option value="1">Đang Làm</option>
            <option value="0">Đã Nghỉ</option>
        </select>
    </div>

    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit" onclick="return validateForm(event, 'form')">Add</button>
    </div>

</form>


