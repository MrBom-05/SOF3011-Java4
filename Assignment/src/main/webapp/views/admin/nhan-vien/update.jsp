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

<h2 class="mt-3 text-center">Cập Nhật Nhân Viên</h2>

<form class="row g-3 needs-validation col-10 offset-1 mt-3 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/nhan-vien/update?ma=${nhanVien.ma}" id="form">

    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Tên<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom01" name="ten" value="${nhanVien.ten}" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Tên Đệm<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom02" name="tenDem" value="${nhanVien.tenDem}"
               required onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Họ<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom03" name="ho" value="${nhanVien.ho}" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">Ngày Sinh<span class="text-danger">*</span></label>
        <input type="date" class="form-control" id="validationCustom04" name="ngaySinh" value="${nhanVien.ngaySinh}"
               required onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">SDT<span class="text-danger">*</span></label>
        <input type="number" class="form-control" id="validationCustom05" name="sdt" value="${nhanVien.sdt}" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom05" class="form-label">Email<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom06" name="email" value="${nhanVien.email}" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Địa Chỉ<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom07" name="diaChi" value="${nhanVien.diaChi}"
               required onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Cửa Hàng<span class="text-danger">*</span></label>
        <select class="form-select" name="idCuaHang">
            <option value="false" disabled selected>-- Chọn Của Hàng --</option>
            <c:forEach var="cuaHang" items="${listCuaHang}">
                <option value="${cuaHang.id}" ${cuaHang.id == idCuaHang ? "selected" : ""}>${cuaHang.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Chức Vụ<span class="text-danger">*</span></label>
        <select class="form-select" name="idChucVu">
            <option value="false" disabled selected>-- Chọn Chức Vụ --</option>
            <c:forEach var="chucVu" items="${listChucVu}">
                <option value="${chucVu.id}" ${chucVu.id == idChucVu ? "selected" : ""}>${chucVu.ten}</option>
            </c:forEach>
        </select>
    </div>

    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Mật Khẩu<span class="text-danger">*</span></label>
        <input type="password" class="form-control" id="validationCustom10" name="matKhau" value="${nhanVien.matKhau}"
               required onblur="validateRed(this)">
    </div>

    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Mã<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom011" name="ma" value="${nhanVien.ma}" required
               disabled onblur="validateRed(this)">
    </div>

    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Giới Tính</label>
        <div class="row mt-1">
            <div class="form-check col-6">
                <input ${nhanVien.gioiTinh == "Nam" ? "checked" : ""} class="form-check-input ms-5" value="Nam"
                                                                      type="radio" name="gioiTinh" id="rdoTrue" checked
                                                                      required>
                <label class="form-check-label ms-2">Nam</label>
            </div>
            <div class="form-check col-6">
                <input ${nhanVien.gioiTinh == "Nữ" ? "checked" : ""} class="form-check-input" value="Nữ" type="radio"
                                                                     name="gioiTinh" id="rdoFalse" required>
                <label class="form-check-label">Nữ</label>
            </div>
        </div>
    </div>

    <div class="col-md-4 offset-4">
        <label class="form-label">Trạng Thái<span class="text-danger">*</span></label>
        <select class="form-select" name="trangThai">
            <option value="false" disabled selected>-- Chọn Trạng Thái --</option>
            <option value="1" ${nhanVien.trangThai == 1 ? "selected" : ""}>Đang Làm</option>
            <option value="0" ${nhanVien.trangThai == 0 ? "selected" : ""}>Đã Nghỉ</option>
        </select>
    </div>

    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit" onclick="return validateForm(event, 'form')">
            Update
        </button>
    </div>

</form>


