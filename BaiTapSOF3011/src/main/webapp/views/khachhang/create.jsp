<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/10/2023
  Time: 2:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Khách Hàng</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<form class="row g-3 needs-validation col-10 offset-1 mt-5" novalidate>
    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Tên</label>
        <input type="text" class="form-control" id="validationCustom01" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Tên Đệm</label>
        <input type="text" class="form-control" id="validationCustom02" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Họ</label>
        <input type="text" class="form-control" id="validationCustom03" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" id="validationCustom04" required>
        <div class="invalid-feedback">
            Please provide a valid city.
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom03" class="form-label">SDT</label>
        <input type="number" class="form-control" id="validationCustom05" required>
        <div class="invalid-feedback">
            Please provide a valid city.
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom05" class="form-label">Email</label>
        <input type="text" class="form-control" id="validationCustom06" required>
        <div class="invalid-feedback">
            Please provide a valid zip.
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" id="validationCustom07" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Thành Phố</label>
        <input type="text" class="form-control" id="validationCustom08" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">Quốc Gia</label>
        <input type="text" class="form-control" id="validationCustom09" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>

    <div class="col-md-6">
        <label for="validationCustom02" class="form-label">Mật Khẩu</label>
        <input type="password" class="form-control" id="validationCustom10" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>

    <div class="col-md-6">
        <label for="validationCustom02" class="form-label">Mã</label>
        <input type="text" class="form-control" id="validationCustom011" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Add</button>
    </div>
</form>
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/popper.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
