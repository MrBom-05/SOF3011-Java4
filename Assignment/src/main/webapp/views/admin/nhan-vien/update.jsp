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
      action="/Assignment_war_exploded/admin/khach-hang/update?ma=${nhanVien.ma}" id="form">

    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Tên</label>
        <input type="text" class="form-control" id="validationCustom01" name="ten" value="${nhanVien.ten}" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Tên Đệm</label>
        <input type="text" class="form-control" id="validationCustom02" name="tenDem" value="${nhanVien.tenDem}" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Họ</label>
        <input type="text" class="form-control" id="validationCustom03" name="ho" value="${nhanVien.ho}" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" id="validationCustom04" name="ngaySinh" value="${nhanVien.ngaySinh}" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">SDT</label>
        <input type="number" class="form-control" id="validationCustom05" name="sdt" value="${nhanVien.sdt}" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom05" class="form-label">Email</label>
        <input type="text" class="form-control" id="validationCustom06" name="email" value="${nhanVien.email}" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" id="validationCustom07" name="diaChi" value="${nhanVien.diaChi}" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Cửa Hàng</label>
        <select class="form-select" name="idCuaHang">
            <option value="" disabled selected>-- Chọn Của Hàng --</option>
            <c:forEach var="cuaHang" items="${listCuaHang}">
                <option value="${cuaHang.id}" ${cuaHang.id == idCuaHang ? "selected" : ""}>${cuaHang.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Chức Vụ</label>
        <select class="form-select" name="idChucVu">
            <option value="" disabled selected>-- Chọn Chức Vụ --</option>
            <c:forEach var="chucVu" items="${listChucVu}">
                <option value="${chucVu.id}" ${chucVu.id == idChucVu ? "selected" : ""}>${chucVu.ten}</option>
            </c:forEach>
        </select>
    </div>

    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Mật Khẩu</label>
        <input type="password" class="form-control" id="validationCustom10" name="matKhau" value="${nhanVien.matKhau}" required>
    </div>

    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Mã</label>
        <input type="text" class="form-control" id="validationCustom011" name="ma" value="${nhanVien.ma}" required disabled>
    </div>

    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Giới Tính</label>
        <div class="row mt-1">
            <div class="form-check col-6">
                <input ${nhanVien == "Nam" ? "checked" : ""} class="form-check-input ms-5" value="Nam" type="radio" name="gioiTinh" id="rdoTrue" checked required>
                <label class="form-check-label ms-2">Nam</label>
            </div>
            <div class="form-check col-6">
                <input ${nhanVien == "Nữ" ? "checked" : ""} class="form-check-input" value="Nữ" type="radio" name="gioiTinh" id="rdoFalse" required>
                <label class="form-check-label">Nữ</label>
            </div>
        </div>
    </div>

    <div class="col-md-4 offset-4">
        <label class="form-label">Trạng Thái</label>
        <select class="form-select" name="trangThai">
            <option value="" disabled selected>-- Chọn Trạng Thái --</option>
            <option value="1" ${nhanVien.trangThai == 1 ? "selected" : ""}>Đang Làm</option>
            <option value="0" ${nhanVien.trangThai == 0 ? "selected" : ""}>Đã Nghỉ</option>
        </select>
    </div>

</form>

<script>
    const form = document.getElementById('form');
    form.addEventListener('submit', function (event) {
        const ma = document.querySelector('input[name="ma"]');
        const ten = document.querySelector('input[name="ten"]');
        const tenDem = document.querySelector('input[name="tenDem"]');
        const ho = document.querySelector('input[name="ho"]');
        const ngaySinh = document.querySelector('input[name="ngaySinh"]');
        const sdt = document.querySelector('input[name="sdt"]');
        const email = document.querySelector('input[name="email"]');
        const diaChi = document.querySelector('input[name="diaChi"]');
        const thanhPho = document.querySelector('input[name="thanhPho"]');
        const quocGia = document.querySelector('input[name="quocGia"]');
        const matKhau = document.querySelector('input[name="matKhau"]');
        if (!ma.value || !ten.value || !tenDem.value || !ho.value || !ngaySinh.value || !sdt.value || !email.value || !diaChi.value
            || !thanhPho.value || !quocGia.value || !matKhau.value) {
            alert("Không được để trống!");
            event.preventDefault(); // Ngăn chặn gửi form
        }
    });

</script>

