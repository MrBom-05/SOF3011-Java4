<%--
  Created by IntelliJ IDEA.
  User: 84987
  Date: 4/13/2023
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/LuyenTap2_war_exploded/cua-hang/add">
    <div>
        <label>Ma</label>
        <input type="text" name="ma" required>
    </div>
    <div>
        <label>Ten</label>
        <input type="text" name="ten" required>
    </div>
    <div>
        <label>Thanh Pho</label>
        <select name="thanhPho">
            <option value="Ha Noi">Ha Noi</option>
            <option value="Ho Chi Minh">Ho Chi Minh</option>
        </select>
    </div>
    <div>
        <label>Dia Chi</label>
        <input type="text" name="diaChi" required>
    </div>
    <button type="submit">Add</button>
</form>
</body>
</html>
