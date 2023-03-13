<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <c:forEach var="cv" items="${ list }" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${ cv.ma }</td>
            <td>${ cv.ten }</td>

            <td class="text-center">
                <a href="/Assignment_war_exploded/admin/chucvu/edit?ma=${ cv.ma }" class="btn btn-primary">Update</a>
                <a href="/Assignment_war_exploded/admin/chucvu/delete?ma=${ cv.ma }" class="btn btn-danger">Delete</a>
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
