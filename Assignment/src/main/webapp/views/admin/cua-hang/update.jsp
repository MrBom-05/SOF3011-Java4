<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="mt-3 text-center">Cập Nhật Cửa Hàng</h2>

<form class="col-6 offset-3 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/cua-hang/update?id=${cuaHang.id}" id="form">

    <div class="row">
        <div class="col-4">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã</span>
                <input type="text" class="form-control" name="ma" value="${cuaHang.ma}" disabled>
            </div>
        </div>

        <div class="col-8">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Tên</span>
                <input type="text" class="form-control" name="ten" value="${cuaHang.ten}">
            </div>
        </div>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">Địa chỉ</span>
        <textarea class="form-control" aria-label="With textarea" name="diaChi">${cuaHang.diaChi}</textarea>
    </div>

    <div class="row">
        <div class="col-8">
            <div class="input-group mb-3">
                <span class="input-group-text">Thành Phố</span>
                <input type="text" class="form-control" name="thanhPho" value="${cuaHang.thanhPho}">
            </div>
        </div>

        <div class="col-4">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Quốc Gia</span>
                <input type="text" class="form-control" name="quocGia" value="${cuaHang.quocGia}">
            </div>
        </div>
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Update</button>
    </div>

</form>

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

