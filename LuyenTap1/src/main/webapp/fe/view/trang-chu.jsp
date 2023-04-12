<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 14/03/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhan Vien</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
</head>
<body>

<div>
    ${thongBao}
</div>

<form method="post" action="/pe_war_exploded/nhan-vien/add">
    <div>
        <label>Ma</label>
        <input type="text" name="ma" value="${nv.ma}" required>
    </div>
    <div>
        <label>Ten</label>
        <input type="text" name="ten" value="${nv.ten}" required>
    </div>
    <div>
        <label>Gioi Tinh</label>
        <input type="radio" value="Nam" name="gioiTinh" ${nv.gioiTinh == "Nam" ? "checked" : ""} checked required>
        <label>Nam</label>

        <input type="radio" value="Nu" name="gioiTinh" ${nv.gioiTinh == "Nu" ? "checked" : ""} required>
        <label>Nu</label>
    </div>
    <div>
        <label>Dia Chi</label>
        <input type="text" name="diaChi" value="${nv.diaChi}" required>
    </div>
    <button type="submit">Add</button>
</form>

<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gioi Tinh</th>
        <th>Dia Chi</th>
        <th>Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="nhanVien" items="${list}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${nhanVien.ma}</td>
            <td>${nhanVien.ten}</td>
            <td>${nhanVien.gioiTinh}</td>
            <td>${nhanVien.diaChi}</td>
            <td>
                <a type="button" href="/pe_war_exploded/nhan-vien/detail?ma=${nhanVien.ma}">Detail</a>
                <a type="button" href="/pe_war_exploded/nhan-vien/delete?ma=${nhanVien.ma}" onclick="return confirm('Ban co muon xoa khong')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>