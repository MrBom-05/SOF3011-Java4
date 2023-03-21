<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="mt-3 text-center">Thêm Mới Dòng Sản Phẩm</h2>

<form class="col-6 offset-3 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/dong-sp/store" id="form">

    <div class="col-12">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma" required>
    </div>

    <div class="col-12 mt-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="ten" required>
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Add</button>
    </div>

</form>

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

