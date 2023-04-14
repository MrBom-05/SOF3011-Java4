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
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<div>
    ${thongBao}
</div>

<form method="post" action="/LuyenTap3_war_exploded/khach-hang/add">
    <div>
        <label>Ma</label>
        <input type="text" name="ma" required value="${khachHang.ma}">
    </div>

    <div>
        <label>Ten</label>
        <input type="text" name="ten" required value="${khachHang.ten}">
    </div>

    <div>
        <label>Dia Chi</label>
        <input type="text" name="diaChi" required value="${khachHang.diaChi}">
    </div>

    <div>
        <select name="quocGia">
            <option value="Vien Nam" ${khachHang.quocGia == "Vien Nam" ? "selected" : ""}>Viet Nam</option>
            <option value="Trung Quoc" ${khachHang.quocGia == "Trung Quoc" ? "selected" : ""}>Trung Quoc</option>
        </select>
    </div>
    <button type="submit">Add</button>
</form>

<c:if test="${f:length(list) == 0}">
    <h2>khong co du lieu</h2>
</c:if>

<c:if test="${f:length(list) != 0}">
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>Dia Chi</th>
            <th>Quoc Gia</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="khachHang" items="${list}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${khachHang.ma}</td>
                <td>${khachHang.ten}</td>
                <td>${khachHang.diaChi}</td>
                <td>${khachHang.quocGia}</td>
                <td>
                    <a type="button" href="/LuyenTap3_war_exploded/khach-hang/detail?ma=${khachHang.ma}">Detail</a>
                    <a type="button" href="/LuyenTap3_war_exploded/khach-hang/delete?ma=${khachHang.ma}"
                       onclick="return confirm('Ban co muon xoa khong')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>