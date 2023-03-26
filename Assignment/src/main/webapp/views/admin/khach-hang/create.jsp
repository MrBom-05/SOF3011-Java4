<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="mt-3 text-center">Thêm Mới Khách Hàng</h2>

<form class="row g-3 needs-validation col-10 offset-1 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/khach-hang/store" id="form">

    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Tên<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom01" name="ten" required onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Tên Đệm<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom02" name="tenDem" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Họ<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom03" name="ho" required onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" id="validationCustom04" name="ngaySinh">
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">SDT<span class="text-danger">*</span></label>
        <input type="number" class="form-control" id="validationCustom05" name="sdt" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom05" class="form-label">Email<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom06" name="email" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Địa Chỉ<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom07" name="diaChi" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Thành Phố<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom08" name="thanhPho" required
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Quốc Gia<span class="text-danger">*</span></label>
        <input type="text" class="form-control" id="validationCustom09" name="quocGia" required
               onblur="validateRed(this)">
    </div>

    <div class="col-md-6">
        <label for="validationCustom02" class="form-label">Mật Khẩu<span class="text-danger">*</span></label>
        <input type="password" class="form-control" id="validationCustom10" name="matKhau" required
               onblur="validateRed(this)">
    </div>

    <div class="col-md-6">
        <label for="validationCustom02" class="form-label">Mã</label>
        <input type="text" class="form-control" id="validationCustom011" name="ma" required disabled
               onblur="validateRed(this)">
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit" onclick="return validateForm(event, 'form')">Add
        </button>
    </div>

</form>


