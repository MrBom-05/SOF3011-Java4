<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
    <link rel="stylesheet" href="/Assignment_war_exploded/bootstrap/css/bootstrap.min.css">
</head>
<body>
<form class="row g-3 needs-validation col-10 offset-1 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/khach-hang/store" id="form">

    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Tên</label>
        <input type="text" class="form-control" id="validationCustom01" name="ten" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Tên Đệm</label>
        <input type="text" class="form-control" id="validationCustom02" name="tenDem" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Họ</label>
        <input type="text" class="form-control" id="validationCustom03" name="ho" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" id="validationCustom04" name="ngaySinh" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">SDT</label>
        <input type="number" class="form-control" id="validationCustom05" name="sdt" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom05" class="form-label">Email</label>
        <input type="text" class="form-control" id="validationCustom06" name="email" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" id="validationCustom07" name="diaChi" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Thành Phố</label>
        <input type="text" class="form-control" id="validationCustom08" name="thanhPho" required>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Quốc Gia</label>
        <input type="text" class="form-control" id="validationCustom09" name="quocGia" required>
    </div>

    <div class="col-md-6">
        <label for="validationCustom02" class="form-label">Mật Khẩu</label>
        <input type="password" class="form-control" id="validationCustom10" name="matKhau" required>
    </div>

    <div class="col-md-6">
        <label for="validationCustom02" class="form-label">Mã</label>
        <input type="text" class="form-control" id="validationCustom011" name="ma" required>
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Add</button>
    </div>

</form>
<script src="/Assignment_war_exploded/bootstrap/js/jquery.min.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/popper.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/bootstrap.min.js"></script>
<script>
    const form = document.getElementById('form');
    form.addEventListener('submit', function (event) {
        const ma = document.querySelector('input[name="ma"]');
        const ten = document.querySelector('input[name="ten"]');
        if (!ma.value || !ten.value) {
            alert("Không được để trống!");
            event.preventDefault(); // Ngăn chặn gửi form
        }
    });

</script>
</body>
</html>
