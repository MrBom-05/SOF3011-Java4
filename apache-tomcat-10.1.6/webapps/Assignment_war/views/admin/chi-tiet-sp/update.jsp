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
<html>
<head>
    <title>Cập Nhật</title>
    <link rel="stylesheet" href="/Assignment_war_exploded/bootstrap/css/bootstrap.min.css">
</head>
<body>
<form class="row g-3 needs-validation col-10 offset-1 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/chi-tiet-sp/update" id="form">

    <div class="col-md-6">
        <label class="form-label">Sản Phẩm</label>
        <select class="form-select" name="idSanPham">
            <option value="" disabled selected>-- Chọn Sản Phẩm --</option>
            <c:forEach var="sanPham" items="${listSanPham}">
                <option value="${sanPham.id}" ${sanPham.id == idSanPham ? "selected" : ""}>${sanPham.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Màu Sắc</label>
        <select class="form-select" name="idMauSac">
            <option value="" disabled selected>-- Chọn Màu Sắc --</option>
            <c:forEach var="mauSac" items="${listMauSac}">
                <option value="${mauSac.id}" ${mauSac.id == idMauSac ? "selected" : ""}>${mauSac.ten}</option>
            </c:forEach>
        </select>
    </div>

    <div class="col-md-6">
        <label class="form-label">Dòng SP</label>
        <select class="form-select" name="idDongSP">
            <option value="" disabled selected>-- Chọn Dòng SP --</option>
            <c:forEach var="dongSP" items="${listDongSP}">
                <option value="${dongSP.id}" ${dongSP.id == idDongSP ? "selected" : ""}>${dongSP.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Nhà Sản Xuất</label>
        <select class="form-select" name="idNSX">
            <option value="" disabled selected>-- Chọn Nhà Sản Xuất --</option>
            <c:forEach var="nsx" items="${listNSX}">
                <option value="${nsx.id}" ${nsx.id == idNSX ? "selected" : ""}>${nsx.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-3">
        <label class="form-label">Năm Sản Xuất</label>
        <input type="number" class="form-control" id="validationCustom04" name="namSX" value="${chiTietSP.namSX}"
               required>
    </div>
    <div class="col-md-3">
        <label class="form-label">Số Lượng</label>
        <input type="number" class="form-control" id="validationCustom05" name="soLuongTon"
               value="${chiTietSP.soLuongTon}" required>
    </div>
    <div class="col-md-3">
        <label for="validationCustom05" class="form-label">Giá Nhập</label>
        <input type="number" class="form-control" id="validationCustom06" name="giaNhap" value="${chiTietSP.giaNhap}"
               required>
    </div>
    <div class="col-md-3">
        <label class="form-label">Giá Bán</label>
        <input type="number" class="form-control" id="validationCustom07" name="giaBan" value="${chiTietSP.giaBan}"
               required>
    </div>

    <div class="col-12">
        <span class="form-label">Mô Tả</span>
        <textarea class="form-control" aria-label="With textarea" name="moTa">${chiTietSP.moTa}</textarea>
    </div>


    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Update</button>
    </div>

</form>
<script src="/Assignment_war_exploded/bootstrap/js/jquery.min.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/popper.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/bootstrap.min.js"></script>
<script>
    const form = document.getElementById('form');
    form.addEventListener('submit', function (event) {
        const namSX = document.querySelector('input[name="namSX"]');
        const soLuongTon = document.querySelector('input[name="soLuongTon"]');
        const giaNhap = document.querySelector('input[name="giaNhap"]');
        const giaBan = document.querySelector('input[name="giaBan"]');
        const moTa = document.querySelector('input[name="moTa"]');
        if (!namSX.value || !soLuongTon.value || !giaNhap.value || !giaBan.value || !moTa.value) {
            alert("Không được để trống!");
            event.preventDefault(); // Ngăn chặn gửi form
        }
    });
</script>
</body>
</html>
