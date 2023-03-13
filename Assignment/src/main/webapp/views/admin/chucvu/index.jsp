<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách</title>
    <link rel="stylesheet" href="/Assignment_war_exploded/bootstrap/css/bootstrap.min.css">
</head>
<body class="col-10 offset-1">

<h2 class="mt-3">Quản Lý Chức Vụ</h2>

<a href="/Assignment_war_exploded/admin/chucvu/create" class="btn btn-success mt-3">Add</a>

<table class="table table-bordered mt-5">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th class="col-2 text-center">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="kh" items="${ list }">
        <tr>
            <td>${ kh.ten }</td>
            <td>${ kh.ten }</td>
            <td>${ kh.tenDem }</td>

            <td class="text-center">
                <a href="/IT17202/admin/sinh-vien/edit?id=${ sv.id }" class="btn btn-primary">Update</a>
                <a href="/IT17202/admin/sinh-vien/delete?id=${ sv.id }" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="/Assignment_war_exploded/bootstrap/js/jquery.min.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/popper.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
