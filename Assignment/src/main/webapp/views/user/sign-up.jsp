<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Ký</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"/>
    <style>
        body {
            background-color: #eee;
        }

        .card {
            margin: 30px auto 30px auto;
            max-width: 900px;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.2);
        }

        .card-header {
            background-color: #fff;
            border-bottom: none;
        }

        .form-control:focus {
            border-color: #3F51B5;
            box-shadow: none;
        }

        .btn-primary {
            background-color: #3F51B5;
            border-color: #3F51B5;
        }

        .btn-primary:hover {
            background-color: #303F9F;
            border-color: #303F9F;
        }

        .form-label {
            font-weight: 500;
        }

        .form-text a {
            color: #3F51B5;
        }
    </style>
</head>
<body>

<div class="card">
    <div class="card-header">
        <h4 class="text-center">Sign Up</h4>
    </div>
    <div class="card-body">
        <form class="row g-3 needs-validation" novalidate method="POST"
              action="/Assignment_war_exploded/sign-up" id="form">

            <div class="col-md-4">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" id="validationCustom01" name="ten" required>
            </div>
            <div class="col-md-4">
                <label class="form-label">Tên Đệm</label>
                <input type="text" class="form-control" id="validationCustom02" name="tenDem" required>
            </div>
            <div class="col-md-4">
                <label class="form-label">Họ</label>
                <input type="text" class="form-control" id="validationCustom03" name="ho" required>
            </div>
            <div class="col-md-4">
                <label class="form-label">Ngày Sinh</label>
                <input type="date" class="form-control" id="validationCustom04" name="ngaySinh" required>
            </div>
            <div class="col-md-4">
                <label class="form-label">SDT</label>
                <input type="number" class="form-control" id="validationCustom05" name="sdt" required>
            </div>
            <div class="col-md-4">
                <label class="form-label">Email</label>
                <input type="text" class="form-control" id="validationCustom06" name="email" required>
            </div>
            <div class="col-md-4">
                <label class="form-label">Địa Chỉ</label>
                <input type="text" class="form-control" id="validationCustom07" name="diaChi" required>
            </div>
            <div class="col-md-4">
                <label class="form-label">Thành Phố</label>
                <input type="text" class="form-control" id="validationCustom08" name="thanhPho" required>
            </div>
            <div class="col-md-4">
                <label class="form-label">Quốc Gia</label>
                <input type="text" class="form-control" id="validationCustom09" name="quocGia" required>
            </div>

            <div class="col-md-6">
                <label class="form-label">Mật Khẩu</label>
                <input type="password" class="form-control" name="matKhau" required>
            </div>

            <div class="col-md-6">
                <label class="form-label">Nhập Lại Mật Khẩu</label>
                <input type="password" class="form-control" name="matKhauConfirm" required>
            </div>
            <div class="col-12 mt-5">
                <button class="btn btn-primary col-2 offset-5" type="submit">Sign Up</button>
            </div>

        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/Assignment_war_exploded/js/bootstrap.min.js"></script>
<script>
    const form = document.getElementById('form');
    form.addEventListener('submit', function (event) {
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
        const matKhauConfirm = document.querySelector('input[name="matKhauConfirm"]');

        if (!ten.value || !tenDem.value || !ho.value || !ngaySinh.value || !sdt.value || !email.value || !diaChi.value
            || !thanhPho.value || !quocGia.value || !matKhau.value || !matKhauConfirm.value) {
            alert("Không được để trống!");
            event.preventDefault(); // Ngăn chặn gửi form
        }

        if (document.getElementsByName("matKhau")[0].value != document.getElementsByName("matKhauConfirm")[0].value){
            alert("Mật khẩu không giống nhau!");
            event.preventDefault(); // Ngăn chặn gửi form
        }
    });

</script>
</body>
</html>
