<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="mt-3 text-center">Thêm Mới Khách Hàng</h2>

<form class="row g-3 col-10 offset-1 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/khach-hang/update?id=${khachHang.id}" id="form">

    <div class="col-md-4">
        <label class="form-label">Tên<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="ten" required value="${khachHang.ten}"
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên Đệm<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="tenDem" required
               value="${khachHang.tenDem}" onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Họ<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="ho" required value="${khachHang.ho}"
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Ngày Sinh<span class="text-danger">*</span></label>
        <input type="date" class="form-control" name="ngaySinh" required value="${khachHang.ngaySinh}">
    </div>
    <div class="col-md-4">
        <label class="form-label">SDT<span class="text-danger">*</span></label>
        <input type="number" class="form-control" name="sdt" required value="${khachHang.sdt}"
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Email<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="email" required value="${khachHang.email}"
               onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Địa Chỉ<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="diaChi" required
               value="${khachHang.diaChi}" onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Thành Phố<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="thanhPho" required
               value="${khachHang.thanhPho}" onblur="validateRed(this)">
    </div>
    <div class="col-md-4">
        <label class="form-label">Quốc Gia<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="quocGia" required
               value="${khachHang.quocGia}" onblur="validateRed(this)">
    </div>

    <div class="col-md-6">
        <label class="form-label">Mật Khẩu<span class="text-danger">*</span></label>
        <input type="password" class="form-control" name="matKhau" required
               value="${khachHang.matKhau}" onblur="validateRed(this)">
    </div>

    <div class="col-md-6">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma" required value="${khachHang.ma}"
               disabled>
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit" onclick="return validateForm(event, 'form')">
            Update
        </button>
    </div>

</form>

