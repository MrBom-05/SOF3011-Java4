<%--
  Created by IntelliJ IDEA.
  User: 84987
  Date: 4/13/2023
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
</head>
<body>
<a type="button" href="/LuyenTap2_war_exploded/cua-hang/view-add">Add</a>
<a type="button" href="/LuyenTap2_war_exploded/cua-hang/hien-thi">Hien Thi</a>


<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Dia Chi</th>
        <th>Thanh Pho</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cuaHang" items="${list}" varStatus="status">
        <tr>
            <td>${status.index +1}</td>
            <td>${cuaHang.ma}</td>
            <td>${cuaHang.ten}</td>
            <td>${cuaHang.diaChi}</td>
            <td>${cuaHang.thanhPho}</td>
            <td>
                <a type="button" href="/LuyenTap2_war_exploded/cua-hang/view-update?ma=${cuaHang.ma}">Update</a>
                <a type="button" href="/LuyenTap2_war_exploded/cua-hang/detail?ma=${cuaHang.ma}">Detail</a>
                <a type="button" href="/LuyenTap2_war_exploded/cua-hang/delete?ma=${cuaHang.ma}" onclick="return confirm('Ban co muon xoa khong')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
