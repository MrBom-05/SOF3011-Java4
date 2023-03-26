<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="mt-3 text-center">Cập Nhật Màu Sắc</h2>

<form class="col-6 offset-3 mt-5 border p-4" novalidate method="POST"
      action="/Assignment_war_exploded/admin/mau-sac/update?id=${mauSac.id}" id="form">

    <div class="col-12">
        <label class="form-label">Mã<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="ma" required disabled value="${mauSac.ma}"
               onblur="validateRed(this)">
    </div>

    <div class="col-12 mt-3">
        <label class="form-label">Tên<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="ten" required value="${mauSac.ten}" onblur="validateRed(this)">
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit" onclick="return validateForm(event, 'form')">
            Update
        </button>
    </div>

</form>

