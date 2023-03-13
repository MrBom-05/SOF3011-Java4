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
<form class="col-6 offset-3 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/chucvu/store" id="form">

    <div class="row">
        <div class="col-4">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã</span>
                <input type="text" class="form-control" name="ma">
            </div>
        </div>

        <div class="col-8">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Tên</span>
                <input type="text" class="form-control" name="ten">
            </div>
        </div>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">Địa chỉ</span>
        <textarea class="form-control" aria-label="With textarea" name="diaChi"></textarea>
    </div>

    <div class="row">
        <div class="col-8">
            <div class="input-group mb-3">
                <span class="input-group-text">Thành Phố</span>
                <input type="text" class="form-control" name="thanhPho">
            </div>
        </div>

        <div class="col-4">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Quốc Gia</span>
                <input type="text" class="form-control" name="quocGia">
            </div>
        </div>
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
        const diaChi = document.querySelector('input[name="diaChi"]');
        const thanhPho = document.querySelector('input[name="thanhPho"]');
        const quocGia = document.querySelector('input[name="quocGia"]');
        if (!ma.value || !ten.value || !diaChi.value || !thanhPho.value || !quocGia.value) {
            alert("Không được để trống!");
            event.preventDefault(); // Ngăn chặn gửi form
        }
    });

</script>
</body>
</html>
