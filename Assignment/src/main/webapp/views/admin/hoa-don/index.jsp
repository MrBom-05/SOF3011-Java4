<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản Lý Hóa Đơn</title>
    <link rel="stylesheet" href="/Assignment_war_exploded/bootstrap/css/bootstrap.min.css">
</head>
<body class="col-10 offset-1">
<h2 class="mt-3">Quản Lý Sản Phẩm</h2>

<c:if test="${ f:length(list) == 0 }">
    <h4 class="text-center">Không có dữ liệu</h4>
</c:if>

<c:if test="${ f:length(list) != 0 }">

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

        <c:forEach var="sanPham" items="${ list }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ sanPham.ma }</td>
                <td>${ sanPham.ten }</td>

                <td class="text-center">
                    <a href="/Assignment_war_exploded/admin/san-pham/edit?id=${ sanPham.id }"
                       class="btn btn-primary">Update</a>
                    <a href="/Assignment_war_exploded/admin/san-pham/delete?id=${ sanPham.id }"
                       class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<script src="/Assignment_war_exploded/bootstrap/js/jquery.min.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/popper.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
