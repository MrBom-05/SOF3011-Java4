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

<h2 class="mt-3 text-center">Cập Nhật Chi Tiết Sản Phẩm</h2>

<form class="row g-3 needs-validation col-10 offset-1 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/chi-tiet-sp/update?id=${chiTietSP.id}" id="form">

    <div class="col-md-6">
        <label class="form-label">Sản Phẩm<span class="text-danger">*</span></label>
        <select class="form-select" name="idSanPham">
            <option value="false" disabled selected>-- Chọn Sản Phẩm --</option>
            <c:forEach var="sanPham" items="${listSanPham}">
                <option value="${sanPham.id}" ${sanPham.id == idSanPham ? "selected" : ""}>${sanPham.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Màu Sắc<span class="text-danger">*</span></label>
        <select class="form-select" name="idMauSac">
            <option value="false" disabled selected>-- Chọn Màu Sắc --</option>
            <c:forEach var="mauSac" items="${listMauSac}">
                <option value="${mauSac.id}" ${mauSac.id == idMauSac ? "selected" : ""}>${mauSac.ten}</option>
            </c:forEach>
        </select>
    </div>

    <div class="col-md-6">
        <label class="form-label">Dòng SP<span class="text-danger">*</span></label>
        <select class="form-select" name="idDongSP">
            <option value="false" disabled selected>-- Chọn Dòng SP --</option>
            <c:forEach var="dongSP" items="${listDongSP}">
                <option value="${dongSP.id}" ${dongSP.id == idDongSP ? "selected" : ""}>${dongSP.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Nhà Sản Xuất<span class="text-danger">*</span></label>
        <select class="form-select" name="idNSX">
            <option value="false" disabled selected>-- Chọn Nhà Sản Xuất --</option>
            <c:forEach var="nsx" items="${listNSX}">
                <option value="${nsx.id}" ${nsx.id == idNSX ? "selected" : ""}>${nsx.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-3">
        <label class="form-label">Năm Sản Xuất<span class="text-danger">*</span></label>
        <input type="number" class="form-control" min="1" name="namSX" value="${chiTietSP.namSX}"
               required onblur="validateRed(this)">
    </div>
    <div class="col-md-3">
        <label class="form-label">Số Lượng<span class="text-danger">*</span></label>
        <input type="number" class="form-control" min="1" name="soLuongTon"
               value="${chiTietSP.soLuongTon}" required onblur="validateRed(this)">
    </div>
    <div class="col-md-3">
        <label class="form-label">Giá Nhập<span class="text-danger">*</span></label>
        <input type="number" class="form-control" min="1" name="giaNhap" value="${chiTietSP.giaNhap}"
               required onblur="validateRed(this)">
    </div>
    <div class="col-md-3">
        <label class="form-label">Giá Bán<span class="text-danger">*</span></label>
        <input type="number" class="form-control" min="1" name="giaBan" value="${chiTietSP.giaBan}"
               required onblur="validateRed(this)">
    </div>

    <div class="col-12">
        <span class="form-label">Mô Tả<span class="text-danger">*</span></span>
        <textarea class="form-control" aria-label="With textarea" name="moTa">${chiTietSP.moTa}</textarea>
    </div>


    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit" onclick="return validateForm(event, 'form')">
            Update
        </button>
    </div>

</form>


